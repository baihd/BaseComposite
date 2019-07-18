package com.composite.ioc3;

import com.composite.ioc3.context.IocContext;
import com.composite.ioc3.controller.UserController;

public class Main {

    public static void main(String[] args) {
        try {
            UserController userController = (UserController) IocContext.applicationContext.get(UserController.class);
            userController.getUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
