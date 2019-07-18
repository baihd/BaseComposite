package com.composite.ioc2.service.impl;


import com.composite.ioc2.annotation.IocService;
import com.composite.ioc2.service.OrderService;

@IocService(name = "orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public String findOrder(String username) {
        return "用户" + username + "的订单号为001";
    }
}
