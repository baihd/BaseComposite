package com.composite.ioc2;

import com.composite.ioc2.context.SpringContext;
import com.composite.ioc2.service.impl.UserServiceImpl;

public class SpringIocTest {


    /**
     * 1.首先需要实现类似于spring的component-scan:自动包扫描
     * 2.找到该包下面哪些类加了对应的注解
     * 3.找到这些加了注解的类,进行模拟spring初始化功能,beanId和bean实例化功能
     * 4.对应的依赖属性初始化:主要通过反射+已经实例化好的bean集合
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            String path = "com.composite.ioc2.service.impl";
            SpringContext context = new SpringContext(path);
            UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
            System.out.println(userService.findOrder("username"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
