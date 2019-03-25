package com.xkc.learn.bean;

import com.xkc.learn.controller.UserAction;
import com.xkc.learn.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBean10 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");

        UserAction bean = context.getBean(UserAction.class);

        bean.addUser(new User());
    }
}
