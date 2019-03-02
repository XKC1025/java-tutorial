package com.xkc.learn.exception;

/**
 * 继承{@code Exception}的自定义异常对象是编译期异常, 必须对其进行处理
 */
public class ExceptionObj extends Exception {
    // 与父类构造器保持一致
    public ExceptionObj() {
        super();
    }

    public ExceptionObj(String message) {
        super(message);
    }

    public static void main(String[] args) {
        // 必须对异常进行处理
        try {
            throw new ExceptionObj();
        } catch (ExceptionObj exceptionObj) {
            exceptionObj.printStackTrace();
            // 手动对程序进行终止
            return;
        }
    }
}

/**
 * 继承{@code RuntimeException}的自定义异常对象是运行期异常, 无需处理
 */
class ExceptionObj2 extends RuntimeException {
    public ExceptionObj2() {
    }

    public ExceptionObj2(String message) {
        super(message);
    }

    public static void main(String[] args) {
        // 可以不用对异常进行处理, 自动终止程序
        throw new ExceptionObj2();
    }
}
