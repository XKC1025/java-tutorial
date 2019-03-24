package com.xkc.learn.service;

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

    public IUserServiceImpl() {
        System.out.println("创建IUserService对象");
    }
}
