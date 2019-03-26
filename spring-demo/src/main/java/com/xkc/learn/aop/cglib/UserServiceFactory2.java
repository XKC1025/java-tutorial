package com.xkc.learn.aop.cglib;

import com.xkc.learn.aop.proxy.MyAspect;
import com.xkc.learn.impls.IUserServiceImpl;
import com.xkc.learn.service.IUserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserServiceFactory2 {
    public static IUserService createUserService() {
        // 1.目标类
        final IUserService iUserService = new IUserServiceImpl();

        // 2.切面类
        final MyAspect myAspect = new MyAspect();

        // 3.cglib核心类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(iUserService.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                myAspect.before();

                // 执行代理类的方法(目标类和代理类是父子关系)  两种方法等价
                // Object obj = methodProxy.invokeSuper(proxy, args);

                // 执行目标类的方法
                Object obj = method.invoke(iUserService, args);

                myAspect.after();

                return obj;
            }
        });

        IUserServiceImpl proxy = (IUserServiceImpl) enhancer.create();

        return proxy;

    }
}
