package com.xkc.learn.exception;

/**
 * 父类异常是什么, 子类异常就是什么
 */

public class SubAndFatherException {
}

class Father {
    public void show() throws IndexOutOfBoundsException, ClassCastException {

    }

    protected void method() {}
}

class Sub extends Father {
    // 父类抛出多个异常, 子类应该抛出和父类相同的异常, 或者是和父类异常的子类, 或者是不抛出异常
    @Override
    public void show() throws ArrayIndexOutOfBoundsException, ClassCastException {

    }

    // 父类方法不抛出异常, 子类重写的方法只能捕获处理
    @Override
    protected void method() {}
}
