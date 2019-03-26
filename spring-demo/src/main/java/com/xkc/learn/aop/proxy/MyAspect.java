package com.xkc.learn.aop.proxy;

/**
 * 切面类, advice, 给被代理对象添加事务, 日志等功能
 */
public class MyAspect {
    public void before() {
        System.out.println("开启事务");
    }

    public void after() {
        System.out.println("提交事务");
    }
}
