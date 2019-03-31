package com.xkc.learn.transaction;

import com.xkc.learn.transaction.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {

    /**
     * 手动管理事务
     */
    @Test
    public void testTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("transaction.xml");

        IAccountService iAccountService = (IAccountService) context.getBean("iAccountService");

        iAccountService.transfer("zhaojuan", "xukechen", 500);

    }

    /**
     * 自动管理事务
     */
    @Test
    public void testAutoTransaction() {
        ApplicationContext context = new ClassPathXmlApplicationContext("transaction2.xml");

        IAccountService iAccountService = (IAccountService) context.getBean("transferProxyFactoryBean");

        iAccountService.transfer("xukechen", "zhaojuan", 500);

    }
}
