package com.composite.ioc3.context;

import com.composite.ioc3.annotation.Component;
import com.composite.ioc3.util.IocUtil;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Ioc容器实现类
 */
public class IocContext {
    public static final Map<Class<?>, Object> applicationContext = new ConcurrentHashMap<>();

    static {
        String packageName = "com.composite.ioc3";
        try {
            initBean(packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initBean(String packageName) throws Exception {
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));
        while (urls.hasMoreElements()) {
            addClassByAnnotation(urls.nextElement().getPath(), packageName);
        }
        //IOC实现,自动注入
        IocUtil.inject();
    }

    //获取指定包路径下实现Component主键Bean的实例
    private static void addClassByAnnotation(String filePath, String packageName) {
        try {
            File[] files = getClassFile(filePath);
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile()) {
                        Class<?> clazz = Class.forName(packageName + "." + fileName.substring(0, fileName.lastIndexOf(".")));
                        //判断该类是否实现了注解
                        if (clazz.isAnnotationPresent(Component.class)) {
                            applicationContext.put(clazz, clazz.newInstance());
                        }
                    } else {
                        addClassByAnnotation(file.getPath(), packageName + "." + fileName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取该路径下所遇的class文件和目录
    private static File[] getClassFile(String filePath) {
        return new File(filePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".class") || file.isDirectory();
            }
        });
    }


}
