package com.xkc.learn.aop.cglib;

import com.xkc.learn.service.IUserService;

public class MyCgLib {
    public static void main(String[] args) {
        IUserService userService = UserServiceFactory2.createUserService();

        userService.addUser();
    }
}
