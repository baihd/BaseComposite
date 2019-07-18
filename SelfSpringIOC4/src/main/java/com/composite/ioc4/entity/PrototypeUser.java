package com.composite.ioc4.entity;

import com.composite.ioc4.annotation.MyComponent;
import com.composite.ioc4.annotation.MyValue;

@MyComponent(scope = "prototype")
public class PrototypeUser {
    @MyValue("2")
    private Integer id;
    @MyValue("lisi")
    private String name;
    @MyValue("lisi")
    private String password;

    public PrototypeUser() {
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
