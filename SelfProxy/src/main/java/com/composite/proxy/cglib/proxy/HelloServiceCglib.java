package com.composite.proxy.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB代理类,实现MethodInterceptor接口
 */
public class HelloServiceCglib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象，并返回
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    /**
     * 需实现intercept接口
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("###### self cglib动态代理######");
        //执行方法,相当于调用HelloServiceImpl类的sayHello方法
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
