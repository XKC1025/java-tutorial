package com.xkc.learn.service;

import com.xkc.learn.domain.User;
import org.springframework.stereotype.Component;

@Component
public class IUserServiceImpl implements IUserService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addUser() {
        System.out.println("保存用户" + name);
    }

    @Override
    public void addUser(User user) {
        System.out.println("添加用户: " + user);
    }

    public IUserServiceImpl() {
        System.out.println("创建IUserService对象");
    }
}
