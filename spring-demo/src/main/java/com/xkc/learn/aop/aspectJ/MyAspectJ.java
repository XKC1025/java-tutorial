package com.xkc.learn.aop.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类:
 *      不需要实现MethodInterceptor接口
 * @link {#MyAspect2}
 */
public class MyAspectJ {
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知..." + joinPoint);
    }

    // 后置通知获取业务方法的返回值
    public void myAfterReturning(JoinPoint joinPoint, Object value) {
        System.out.println("后置通知..." + joinPoint);
        System.out.println("返回值: " + value);
    }

    // 环绕通知, 需要放行方法, 不能返回void
    // 传入执行连接点
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知前...");

        System.out.println(proceedingJoinPoint.getSignature().getName());

        // 执行业务方法
        // 放行
        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("环绕通知后...");

        return proceed;
    }

    // 异常通知
    public void myThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("出错啦....");
    }

    // 最终通知
    public void myAfter(JoinPoint joinPoint) {
        System.out.println("最终通知....");
    }
}
