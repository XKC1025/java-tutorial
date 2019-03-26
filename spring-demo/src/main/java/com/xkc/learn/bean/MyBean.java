package com.xkc.learn.bean;

import com.xkc.learn.impls.IUserServiceImpl;
import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBean {
    public static void main(String[] args) {
        // 1.通过类路径加载xml配置文件, 创建对象
        // 即时加载, 此时对象创建完成
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 2.通过文件系统路径获得配置文件
        // 即时加载
        // ApplicationContext context = new FileSystemXmlApplicationContext("/home/xukechen/JavaEE/workspace/java-tutorial/spring-demo/src/main/resources/beans.xml");

        // 3.使用BeanFactory
        // 延时加载, 调用getBean()才会创建对象
        // BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(new File("beans.xml")));

        // 从容器中获取Bean
        IUserService userService = (IUserServiceImpl)context.getBean("userService");
        IUserService userService2 = (IUserServiceImpl)context.getBean("userService");

        // 默认是单例
        System.out.println(userService);
        System.out.println(userService2);

        // 调用方法
        userService.addUser();
        userService2.addUser();
    }
}
