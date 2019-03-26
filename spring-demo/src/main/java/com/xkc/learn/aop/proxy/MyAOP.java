package com.xkc.learn.aop.proxy;

import com.xkc.learn.service.IUserService;

/**
 * 动态代理实现AOP
 */
public class MyAOP {
    public static void main(String[] args) {
        // 获得是代理对象
        IUserService iUserService = UserServiceFactory.createUserService();
        iUserService.addUser();
    }
}
