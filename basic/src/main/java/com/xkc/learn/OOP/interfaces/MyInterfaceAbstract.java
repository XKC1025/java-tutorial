package com.xkc.learn.OOP.interfaces;

public abstract class MyInterfaceAbstract implements MyInterface {
    @Override
    public void f() {
        System.out.println("f()");
    }

    @Override
    public void g() {
        System.out.println("g()");
    }

    // 抽象类可以只实现一部分接口方法
    // 继承的子类必须实现缺少的抽象方法
}
