package com.xkc.learn.aop.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类:
 *      基于注解
 */
@Aspect
@Component("myAspectJ")
public class MyAspectJ2 {
    // 声明公共切入点
    @Pointcut("execution(* com.xkc.learn.impls.*.*(..))")
    public void myPoint() {

    }

    @Before("myPoint()")
    public void myBefore() {
        System.out.println("前置通知...");
    }

    @AfterReturning(value = "myPoint()", returning = "value")
    public void myAfterReturning(JoinPoint joinPoint, Object value) {
        System.out.println("后置通知...");
    }

    @Around("myPoint()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前...");

        // 执行业务方法
        // 放行
        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("环绕通知后...");

        return proceed;
    }

    // 异常通知
    @AfterThrowing(value = "myPoint()", throwing = "throwable")
    public void myThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("出错啦....");
    }

    // 最终通知
    @After("myPoint()")
    public void myAfter(JoinPoint joinPoint) {
        System.out.println("最终通知....");
    }
}
