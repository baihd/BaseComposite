package com.composite.ioc2.service.impl;

import com.composite.ioc2.annotation.IocResource;
import com.composite.ioc2.annotation.IocService;
import com.composite.ioc2.service.OrderService;
import com.composite.ioc2.service.UserService;

@IocService(name = "userService")
public class UserServiceImpl implements UserService {
    @IocResource
    private OrderService orderService;

    @Override
    public String findOrder(String username) {
        return orderService.findOrder(username);
    }
}
