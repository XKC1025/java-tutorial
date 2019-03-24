package com.xkc.learn.bean_factory;

import com.xkc.learn.service.IUserService;
import com.xkc.learn.service.IUserServiceImpl;

public class IUserServiceFactory2 {
    public IUserService createUserService() {
        return new IUserServiceImpl();
    }
}
