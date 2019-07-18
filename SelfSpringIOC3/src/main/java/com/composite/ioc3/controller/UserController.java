package com.composite.ioc3.controller;

import com.composite.ioc3.annotation.Component;
import com.composite.ioc3.annotation.Inject;
import com.composite.ioc3.bean.User;
import com.composite.ioc3.service.UserService;

@Component
public class UserController {

    @Inject
    private UserService userService;

    public void getUser(){
        User user = userService.getUser();
        System.out.println(user);
    }

}
