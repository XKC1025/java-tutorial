package com.xkc.learn.bean;

import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 装配Bean就是在xml文件中配置Bean
 *
 * 装配Bean的三种方式:
 *      1.直接创建
 *      2.通过静态工厂创建
 *      3.实例工厂方法
 */
public class Mybean2 {
    public static void main(String[] args) {
        // 第一种方式
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        IUserService userService = (IUserService)context.getBean("userService");
        userService.addUser();

        // 通过静态工厂创建
        // IUserService userService1 = IUserServiceFactory.createUserService();
        // userService1.addUser();

        // 等价于上面自定义创建对象
        IUserService userService2 = (IUserService)context.getBean("userService2");
        userService2.addUser();

        // 实例工厂方法
        // 创建工厂
        // IUserServiceFactory2 iUserServiceFactory2 = new IUserServiceFactory2();
        // IUserService userService3 = iUserServiceFactory2.createUserService();
        // userService3.addUser();

        IUserService userService3 = (IUserService)context.getBean("userService3");
        userService3.addUser();
    }
}
