package com.xkc.learn.jdk8.functional_interface;

public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void method() {
        System.out.println("Use Impl class!");
    }

    public static void main(String[] args) {
        // 接口中的静态方法  interface.methodName() 调用
        MyFunctionalInterface.g();

        // 默认方法  instance.methodName() 调用
        new MyFunctionalInterfaceImpl().func();
    }
}
