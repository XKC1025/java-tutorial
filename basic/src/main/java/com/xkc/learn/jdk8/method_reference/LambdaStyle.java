package com.xkc.learn.jdk8.method_reference;

/**
 * 方法引用优化lambda表达式:
 *      1.对象和方法都必须存在
 *      2.lambda要表达的方案已经存在某个方法的实现中
 */

public class LambdaStyle {
    private static void print(String string, Printable<String> printable) {
        printable.print(string);
    }

    public static void main(String[] args) {
        print("XKC", o-> System.out.println(o));

        // 使用方法引用
        // 让System.out中的println方法代替lambda表达式
        // lambda中接受的参数一定是方法引用中的方法可以接受的类型
        print("xu ke chen", System.out::println);
    }
}
