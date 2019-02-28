package com.xkc.learn.jdk8.lambda.function_demo;

import java.util.function.Function;

/**
 * Function接口:
 * 将一个数据类型转换成另外一个数据类型
 */
public class FunctionInterface {
    private static void convert(int src, Function<Integer, String> func) {
        String target = func.apply(src);

        System.out.println(target);
    }

    public static void main(String[] args) {
        convert(100, String::valueOf);
    }
}
