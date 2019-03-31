package com.xkc.learn.transaction.service;

import com.xkc.learn.transaction.dao.IAccountDao;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 基于注解的AOP实现事务管理
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, noRollbackFor = ArithmeticException.class)
public class IAccountServiceImpl3 implements IAccountService {
    private static Logger logger = Logger.getLogger(IAccountServiceImpl3.class);

    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public void transfer(final String outer, final String inner, Integer money) {
        iAccountDao.out(outer, 500);

          int i = 10 / 0;

        iAccountDao.inner(inner, 500);
    }
}
