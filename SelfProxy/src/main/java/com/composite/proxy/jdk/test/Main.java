package com.composite.proxy.jdk.test;

import com.composite.proxy.jdk.proxy.HelloServiceProxy;
import com.composite.proxy.service.HelloService;
import com.composite.proxy.service.impl.HelloServiceImpl;

public class Main {

    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloHandler.bind(new HelloServiceImpl());
        proxy.sayHello("zhangsan");
        System.out.println(proxy.getClass());
    }
}
