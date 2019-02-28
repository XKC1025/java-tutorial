package com.xkc.learn.jdk8.method_reference;

public class MulArguments {
    private static class Calc {
        static int add(int a, int b) {
            return a + b;
        }
    }

    private static int method(int a, int b, MulArgumentsInterface<Integer, Integer> mul) {
        return mul.add(a, b);
    }

    public static void main(String[] args) {
        // 方法引用可以使用多个参数
        int result = method(10, 20, Calc::add);
        System.out.println(result);
    }
}
