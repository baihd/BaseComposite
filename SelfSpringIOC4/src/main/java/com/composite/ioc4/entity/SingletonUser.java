package com.composite.ioc4.entity;

import com.composite.ioc4.annotation.MyComponent;
import com.composite.ioc4.annotation.MyValue;

@MyComponent(scope = "singleton")
public class SingletonUser {

    @MyValue("1")
    private Integer id;
    @MyValue("zhangsan")
    private String name;
    @MyValue("123456")
    private String password;

    public SingletonUser() {
        System.out.println("无参构造方法执行");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
