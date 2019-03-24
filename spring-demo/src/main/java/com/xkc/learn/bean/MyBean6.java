package com.xkc.learn.bean;

import com.xkc.learn.domain.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBean6 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans6.xml");
        Customer customer = (Customer) context.getBean("customer");

        System.out.println(customer);
    }
}
