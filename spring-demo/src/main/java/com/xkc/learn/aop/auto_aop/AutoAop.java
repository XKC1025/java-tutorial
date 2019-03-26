package com.xkc.learn.aop.auto_aop;

import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoAop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("proxy2.xml");
        IUserService userService = (IUserService) context.getBean("userService");

        userService.addUser();
    }
}
