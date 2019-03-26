package com.xkc.learn.aop.aopalliance;

import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAOPAlliance {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("proxy.xml");

        // 获取Spring容器中代理对象
        IUserService proxyFactoryBean = (IUserService)context.getBean("proxyFactoryBean");

        proxyFactoryBean.addUser();

    }
}
