package com.composite.mybatis.proxy;

import com.composite.mybatis.bean.Function;
import com.composite.mybatis.bean.MapperBean;
import com.composite.mybatis.configuration.MyConfiguration;
import com.composite.mybatis.session.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyMapperProxy implements InvocationHandler {
    private MySqlSession mySqlSession;
    private MyConfiguration myConfiguration;
    private String path;

    public MyMapperProxy(MySqlSession mySqlSession, MyConfiguration myConfiguration, String path) {
        this.mySqlSession = mySqlSession;
        this.myConfiguration = myConfiguration;
        this.path = path;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean readMapper = myConfiguration.readMapper(path);
        //是否是xml文件对应的接口
        if (!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())) {
            return null;
        }
        List<Function> list = readMapper.getList();
        if (null != list || 0 != list.size()) {
            for (Function function : list) {
                //id是否和接口方法名一样
                if (method.getName().equals(function.getFunctionName())) {
                    return mySqlSession.selectOne(function.getSql(), String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}
