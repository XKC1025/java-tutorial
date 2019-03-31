package com.xkc.learn.transaction.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class IAccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    @Override
    public void out(String outer, Integer money) {
        getJdbcTemplate().update("UPDATE account SET balance = balance - ? WHERE name = ?", money, outer);
    }

    @Override
    public void inner(String inner, Integer money) {
        getJdbcTemplate().update("UPDATE account SET balance = balance + ? WHERE name = ?", money, inner);

    }
}
