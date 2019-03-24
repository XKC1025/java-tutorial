package com.xkc.learn.bean;

import com.xkc.learn.domain.Programmer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 数据结构的注入
 */
public class MyBean7 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans7.xml");

        Programmer programmer = (Programmer)context.getBean("programmer");

        System.out.println(programmer.getCars());
        System.out.println(programmer.getUsers());
        System.out.println(programmer.getWords());
        System.out.println(Arrays.toString(programmer.getInts()));
        System.out.println(programmer.getProperties().getProperty("url"));
    }
}
