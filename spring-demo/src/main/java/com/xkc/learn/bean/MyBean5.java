package com.xkc.learn.bean;

import com.xkc.learn.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 给Bean赋值
 *      1.构造方法注入
 *      2.setter方法注入
 */
public class MyBean5 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans5.xml");

        // 构造方法注入
        Student student = (Student)context.getBean("student");
        System.out.println(student);

        Student student2 = (Student)context.getBean("student2");
        System.out.println(student2);

        // setter方法注入
        Student student3 = (Student)context.getBean("student3");
        System.out.println(student3);

    }
}
