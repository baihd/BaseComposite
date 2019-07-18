package com.composite.ioc4.applicationContext;

import com.composite.ioc4.annotation.MyComponent;
import com.composite.ioc4.annotation.MyValue;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationConfigApplicationContext {

    //此Map容器用于存储类定义对象
    private Map<String, Class<?>> beanDefinitionFactory = new ConcurrentHashMap<>();
    //此Map容器用于存储单例对象
    private Map<String, Object> singletonBeanFactory = new ConcurrentHashMap<>();

    /**
     * 有参构造方法,参数类型为指定要扫描加载的包名
     *
     * @param packageName
     */
    public AnnotationConfigApplicationContext(String packageName) {
            //扫描指定的包路径
            scanPkg(packageName);
    }

    /**
     * 扫描指定包,找到包中的类文件
     * 对于标准(类上有定义注解的)类文件反射加载创建类定义对象并放入容器中
     *
     * @param pkg
     */
    private void scanPkg(final String pkg) {
        //替换包名中的".",将包结构转换为目录结构
        String pkgDir = pkg.replaceAll("\\.", "/");
        //获取目录结构在类路径中的位置(其中url中封装了具体资源的路径)
        URL url = getClass().getClassLoader().getResource(pkgDir);
        //基于这个路径资源(url),构建一个文件对象
        File file = new File(url.getFile());
        //获取此目录中指定标准(以".class"结尾)的文件
        //listFiles是获取该目录下所有文件和目录的绝对路径
        File[] fs = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                //获取文件名
                String fName = file.getName();
                //判断该文件是否为目录，如为目录，递归进一步扫描其内部所有文件
                if (file.isDirectory()) {
                    scanPkg(pkg + "." + fName);
                } else {
                    //判定文件的后缀是否为.class
                    if (fName.endsWith(".class")) {
                        return true;
                    }
                }
                return false;
            }
        });
        //遍历所有符合标准的File文件
        for (File f : fs) {
            //获取文件名
            String fName = f.getName();
            //获取去除.class之后的文件名
            fName = fName.substring(0, fName.lastIndexOf("."));
            //将名字(类名,通常为大写开头)的第一个字母转换小写(用它作为key存储工厂中)
            String beanId = String.valueOf(fName.charAt(0)).toLowerCase() + fName.substring(1);
            //构建一个类全名(包名.类名)
            String pkgCls = pkg + "." + fName;
            try {
                //通过反射构建类对象
                Class<?> c = Class.forName(pkgCls);
                //判定这个类上是否有MyComponent注解
                if (c.isAnnotationPresent(MyComponent.class)) {
                    //将类对象存储到map容器中
                    beanDefinitionFactory.put(beanId, c);
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }


    /**
     * 根据传入的bean的id值获取容器中的对象，类型为Object
     *
     * @param beanId
     * @return
     */
    public Object getBean(String beanId) {
        //根据传入beanId获取类对象
        Class<?> cls = beanDefinitionFactory.get(beanId);
        //根据类对象获取其定义的注解
        MyComponent annotation = cls.getAnnotation(MyComponent.class);
        //获取注解的scope属性值
        String scope = annotation.scope();
        try {
            //如果scope等于singleton,创建单例对象
            if ("singleton".equals(scope) || "".equals(scope)) {
                //判断容器中是否已有该对象的实例,如果没有,创建一个实例对象放到容器中
                if (singletonBeanFactory.get(beanId) == null) {
                    Object instance = cls.newInstance();
                    setFieldValues(cls, instance);
                    singletonBeanFactory.put(beanId, instance);
                }
                //根据beanId获取对象并返回
                return singletonBeanFactory.get(beanId);
            }
            //如果scope等于prototype,则创建并返回多例对象
            if ("prototype".equals(scope)) {
                Object instance = cls.newInstance();
                setFieldValues(cls, instance);
                return instance;
            }
            //目前仅支持单例和多例两种创建对象的方式
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果遭遇异常，返回null
        return null;
    }

    /**
     * 此为重载方法，根据传入的class对象在内部进行强转，返回传入的class对象的类型
     *
     * @param beanId
     * @param c
     * @param <T>
     * @return
     */
    public <T> T getBean(String beanId, Class<T> c) {
        return (T) getBean(beanId);
    }

    /**
     * 此方法用于为对象的属性赋值
     * 内部是通过获取成员属性上注解的值，在转换为类型之后，通过反射为对象赋值
     *
     * @param cls 类定义对象
     * @param obj 要为其赋值的实例对象
     */
    private void setFieldValues(Class<?> cls, Object obj) {
        //获取类中所有的成员属性
        Field[] fields = cls.getDeclaredFields();
        //遍历所有属性
        for (Field field : fields) {
            //如果此属性有MyValue注解修饰，对其进行操作
            if (field.isAnnotationPresent(MyValue.class)) {
                //获取属性名
                String fieldName = field.getName();
                //获取注解中的值
                String value = field.getAnnotation(MyValue.class).value();
                //获取属性所定义的类型
                String type = field.getType().getName();
                //将属性名改为以大写字母开头，如：id改为ID，name改为Name
                fieldName = String.valueOf(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
                //set方法名称，如：setId,setName...
                String setterName = "set" + fieldName;
                try {
                    //根据方法名称和参数类型获取对应的set方法对象
                    Method method = cls.getDeclaredMethod(setterName, field.getType());
                    //判断属性类型，如类型不一致，则转换类型后调用set方法为属性赋值
                    if ("java.lang.Integer".equals(type) || "int".equals(type)) {
                        int intValue = Integer.valueOf(value);
                        method.invoke(obj, intValue);
                    } else if ("java.lang.String".equals(type)) {
                        method.invoke(obj, value);
                    }
                    //作为测试，仅判断Integer和String类型，其它类型同理
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 销毁方法,用于释放资源
     */
    public void close() {
        beanDefinitionFactory.clear();
        beanDefinitionFactory = null;
        singletonBeanFactory.clear();
        singletonBeanFactory = null;
    }


}
