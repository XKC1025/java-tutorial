package com.xkc.learn.jdk8.functional_interface;

/**
 * 接口中只有一个抽象方法, 任意个非抽象方法
 * 若有多个抽象方法, 排除继承Object中的抽象方法
 */

@FunctionalInterface
public interface MyFunctionalInterface {
    void method();

    static void g() {
        System.out.println("static method");
    }

    default void func() {
        System.out.println("default method");
    }
}
