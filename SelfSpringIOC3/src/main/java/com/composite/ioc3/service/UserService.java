package com.composite.ioc3.service;

import com.composite.ioc3.annotation.Component;
import com.composite.ioc3.bean.User;

@Component
public class UserService {
    public User getUser() {
        User user = new User("张三", 20);
        return user;
    }

}
