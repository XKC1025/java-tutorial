package com.xkc.learn.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    private String username;
    private String password;

    {
        System.out.println("1.执行默认初始化");
    }

    public User() {
        System.out.println("2.实例化User");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("3.封装属性: " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void myInit() {
        System.out.println("7.执行自定义init方法");
    }

    public void myDestroy() {
        System.out.println("9.执行自定义destroy方法");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("4.设置Bean名字: " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // 将对象放进Bean工厂, Spring容器
        System.out.println("5.设置BeanFactory: " + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6.属性赋值完成后...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("8.调用destroy()方法");
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
