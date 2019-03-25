package com.xkc.learn.controller;

import com.xkc.learn.domain.User;
import com.xkc.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    @Autowired
    @Qualifier("myService")
    private IUserService iUserService;

    public void addUser(User user) {
        System.out.println("controller 添加用户: " + user);
        iUserService.addUser(user);
    }
}
