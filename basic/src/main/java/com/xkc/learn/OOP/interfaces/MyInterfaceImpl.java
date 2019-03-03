package com.xkc.learn.OOP.interfaces;

public class MyInterfaceImpl extends MyInterfaceAbstract implements MyInterface {
    @Override
    public void m() {
        System.out.println("m()");
    }

    @Override
    public void MyDefault() {
        System.out.println("覆写默认方法");
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();

        myInterface.f();
        myInterface.g();
        myInterface.m();

        // 实现类继承默认方法
        // 也可以在实现类中覆写
        myInterface.MyDefault();

        // 使用接口静态方法, 只能通过接口名进行调用 不可被重写
        // 类可以实现多个接口, 用实现类进行调用有可能导致冲突
        MyInterface.MyStatic();

        // 接口中定义的都是常量
        System.out.println(MyInterface.name);
    }
}
