package com.xkc.learn.transaction.service;

import com.xkc.learn.transaction.dao.IAccountDao;
import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class IAccountServiceImpl implements IAccountService {
    private static Logger logger = Logger.getLogger(IAccountServiceImpl.class);

    private IAccountDao iAccountDao;

    // 配置事务模板
    private TransactionTemplate template;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    public void setTemplate(TransactionTemplate template) {
        this.template = template;
    }

    @Override
    public void transfer(final String outer, final String inner, Integer money) {
        // 开启事务回调
        // 自动提交和回滚
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                iAccountDao.out(outer, 500);

                // int i = 10 / 0;

                iAccountDao.inner(inner, 500);
            }
        });

    }
}
