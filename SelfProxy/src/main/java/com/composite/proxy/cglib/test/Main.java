package com.composite.proxy.cglib.test;

import com.composite.proxy.cglib.proxy.HelloServiceCglib;
import com.composite.proxy.service.HelloService;
import com.composite.proxy.service.impl.HelloServiceImpl;

public class Main {
    public static void main(String[] args) {
        HelloServiceCglib cglib = new HelloServiceCglib();
        HelloService service = (HelloService) cglib.getInstance(new HelloServiceImpl());
        service.sayHello("lisi");
        System.out.println(service.getClass());
    }
}
