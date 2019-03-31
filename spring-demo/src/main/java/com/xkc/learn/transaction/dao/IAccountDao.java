package com.xkc.learn.transaction.dao;

public interface IAccountDao {
    void out(String outer, Integer money);

    void inner(String inner, Integer money);
}
