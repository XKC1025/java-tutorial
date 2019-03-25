package com.xkc.learn.bean;

import com.xkc.learn.domain.User;
import com.xkc.learn.impls.IUserServiceImpl;
import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * web开发流程:
 *      action->service->dao
 */
public class MyBean9 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans9.xml");

        IUserService bean = context.getBean(IUserServiceImpl.class);

        bean.addUser(new User());
    }
}
