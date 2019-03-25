package com.xkc.learn.bean_annotation;

import com.xkc.learn.domain.User;
import com.xkc.learn.impls.IUserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyComponent {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml");

        // xml文件没有指定id, 通过类型获取Bean
        // @Component(id) 可以指定id
        IUserServiceImpl bean = context.getBean(IUserServiceImpl.class);

        bean.addUser(new User());
    }
}
