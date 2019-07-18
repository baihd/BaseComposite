package com.composite.proxy.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类,实现InvocationHandler接口
 */
public class HelloServiceProxy implements InvocationHandler {

    /**
     * 真实服务对象
     */
    private Object target;

    /**
     * 绑定委托对象，并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理对象调用方法首先进入这个方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("###### self JDK动态代理######");
        //执行方法,相当于调用HelloServiceImpl类的sayHello方法
        Object result = method.invoke(target, args);
        return result;
    }

}
