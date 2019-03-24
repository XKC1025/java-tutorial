package com.xkc.learn.bean;

import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Mybean3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");

        // 单例
        IUserService userService = (IUserService)context.getBean("userService");
        System.out.println(userService);

        userService = (IUserService)context.getBean("userService");
        System.out.println(userService);

        // 多例
        IUserService userService2 = (IUserService)context.getBean("userService2");
        System.out.println(userService2);

        userService2 = (IUserService)context.getBean("userService2");
        System.out.println(userService2);

    }
}
