package com.xkc.learn.bean_factory;

import com.xkc.learn.service.IUserService;
import com.xkc.learn.impls.IUserServiceImpl;

public class IUserServiceFactory {
    public static IUserService createUserService() {
        return new IUserServiceImpl();
    }
}
