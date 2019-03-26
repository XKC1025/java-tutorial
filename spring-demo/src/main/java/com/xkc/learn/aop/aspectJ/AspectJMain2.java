package com.xkc.learn.aop.aspectJ;

import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AspectJ测试类
 */
public class AspectJMain2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJ2.xml");

        IUserService iUserService = (IUserService) context.getBean("myService");

        iUserService.addUser();
    }
}
