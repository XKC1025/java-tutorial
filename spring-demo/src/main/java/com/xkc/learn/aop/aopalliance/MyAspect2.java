package com.xkc.learn.aop.aopalliance;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类, advice, 给被代理对象添加事务, 日志等功能
 */
public class MyAspect2 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 拦截方法

        System.out.println("开启事务");
        // 放行方法
        Object proceed = methodInvocation.proceed();

        System.out.println("拦截方法...");
        System.out.println("结束事务");

        return proceed;
    }
}
