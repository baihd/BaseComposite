package com.composite.di4.entity;


import com.composite.di4.annotation.MyComponent;
import com.composite.di4.annotation.MyValue;

@MyComponent
public class User {

    @MyValue("1")
    private Integer id;
    @MyValue("zhangsan")
    private String name;
    @MyValue("123456")
    private String password;

    public User() {
        System.out.println("无参构造方法执行");
    }

    public void login() {
        System.out.println("用户登录:id=" + id + ",name=" + name + ",password=" + password);
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
