package com.xkc.learn.bean;

import com.xkc.learn.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Bean的生命周期
 */
public class Mybean4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        User user = (User) context.getBean("user");

        System.out.println(user);

        // 关闭容器
        context.getClass().getMethod("close", null).invoke(context, null);
    }
}
