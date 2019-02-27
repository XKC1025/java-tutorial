package com.xkc.learn.jdk8.functional_interface;

/**
 * 函数式接口的使用: 作为方法的参数和返回类型
 */

public class UseFunctionalInterface {
    private static void show(MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.method();
    }

    public static void main(String[] args) {
        // 使用实现类
        show(new MyFunctionalInterfaceImpl());

        // 使用匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("Use inner class");
            }
        });

        // 参数是函数式接口, 使用lambda
        show(() -> System.out.println("Known how to use functional interface"));
    }
}
