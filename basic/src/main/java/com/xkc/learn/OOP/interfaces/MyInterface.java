package com.xkc.learn.OOP.interfaces;

public interface MyInterface {
    // 常量, 必须赋值
    public static final String name = "XKC";

    void f();

    void g();

    void m();

    // 默认方法
    default void MyDefault() {
        System.out.println("MyDefault()");
    }

    // static 方法
    static void MyStatic() {
        System.out.println("MyStatic()");
    }
}
