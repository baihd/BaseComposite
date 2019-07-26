package com.composite.mybatis.session;

import com.composite.mybatis.proxy.MyMapperProxy;
import com.composite.mybatis.configuration.MyConfiguration;
import com.composite.mybatis.executor.Excutor;
import com.composite.mybatis.executor.MyExcutor;

import java.lang.reflect.Proxy;

public class MySqlSession {
    private Excutor excutor = new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement, Object parameter) {
        return excutor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz, String path) {
        //动态代理调用
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(this, myConfiguration, path));
    }
}
