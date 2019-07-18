package com.composite.proxy.service.impl;

import com.composite.proxy.service.HelloService;

/**
 * 服务实现类
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
