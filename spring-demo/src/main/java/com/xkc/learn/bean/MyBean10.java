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

        // Bean上@Scope("prototype")注解开启多例模式
        UserAction bean2 = context.getBean(UserAction.class);
        System.out.println(bean);
        System.out.println(bean2);

        // 关闭Bean容器
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}
