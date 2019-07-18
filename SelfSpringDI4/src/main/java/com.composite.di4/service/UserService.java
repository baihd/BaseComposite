package com.composite.di4.service;


import com.composite.di4.annotation.MyAutowired;
import com.composite.di4.annotation.MyComponent;
import com.composite.di4.entity.User;

@MyComponent
public class UserService {
    @MyAutowired
    User user1;

    @MyAutowired
    User user2;

    public void userLogin() {
        System.out.println("用户1:" + user1);
        user1.login();
        System.out.println("用户2:" + user2);
        user2.login();
    }

}
