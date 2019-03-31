package com.xkc.learn.transaction.service;

public interface IAccountService {
    void transfer(String outer, String inner, Integer money);
}
