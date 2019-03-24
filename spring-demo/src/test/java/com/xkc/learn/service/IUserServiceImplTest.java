package com.xkc.learn.service;

import org.junit.Test;

public class IUserServiceImplTest {
    @Test
    public void testService() {
        IUserService iUserService = new IUserServiceImpl();

        iUserService.addUser();

    }

}
