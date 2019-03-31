package com.xkc.learn.transaction.service;

import com.xkc.learn.transaction.dao.IAccountDao;
import org.apache.log4j.Logger;

/**
 * AOP实现事务管理
 */
public class IAccountServiceImpl2 implements IAccountService {
    private static Logger logger = Logger.getLogger(IAccountServiceImpl2.class);

    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public void transfer(final String outer, final String inner, Integer money) {
        iAccountDao.out(outer, 500);

        iAccountDao.inner(inner, 500);
    }
}
