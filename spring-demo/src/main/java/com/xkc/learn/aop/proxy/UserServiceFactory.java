package com.xkc.learn.aop.proxy;

import com.xkc.learn.impls.IUserServiceImpl;
import com.xkc.learn.service.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceFactory {
    public static IUserService createUserService() {
        // 1.创建目标对象 target
        final IUserService iUserService = new IUserServiceImpl();

        // 2.声明切面类对象
        final MyAspect myAspect = new MyAspect();

        // 3.把切面类方法应用到目标类
        // 3.1创建JDK代理
        IUserService iUserServiceProxy = (IUserService) Proxy.newProxyInstance(UserServiceFactory.class.getClassLoader(),
                iUserService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.before();

                        // 返回值是调用方法之后的返回值
                        Object result = method.invoke(iUserService, args);
                        System.out.println("拦截的返回值: " + result);

                        myAspect.after();

                        return result;
                    }
                });

        return iUserServiceProxy;
    }
}
