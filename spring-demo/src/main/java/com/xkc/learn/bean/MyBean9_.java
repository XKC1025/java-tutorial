package com.xkc.learn.bean;

import com.xkc.learn.domain.User;
import com.xkc.learn.impls.IUserServiceImpl;
import com.xkc.learn.impls.IUserServiceImpl2;
import com.xkc.learn.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * web开发流程:
 *      action->service->dao
 */
public class MyBean9_ {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans9_.xml");

        IUserService bean = context.getBean(IUserServiceImpl2.class);

        bean.addUser(new User());
    }
}
