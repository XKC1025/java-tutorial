package com.xkc.learn.jdk8.lambda.function_demo;

import java.util.function.Function;

public class UseAndThen {
    private static void andThen(String src, Function<String, Integer> func1, Function<Integer, String> func2) {
        String target = func1.andThen(func2).apply(src);

        System.out.println(target.length());
    }

    public static void main(String[] args) {
        andThen("1000", Integer::parseInt, String::valueOf);
    }
}
