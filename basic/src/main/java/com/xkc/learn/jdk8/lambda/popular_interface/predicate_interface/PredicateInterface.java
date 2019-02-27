package com.xkc.learn.jdk8.lambda.popular_interface.predicate_interface;

import java.sql.SQLOutput;
import java.util.function.Predicate;

/**
 * Predicate<T>接口:
 * 对某种数据类型进行判断, 返回boolean
 */
public class PredicateInterface {
    private static boolean check(String string, Predicate<String> predicate) {
        return predicate.test(string);
    }

    public static void main(String[] args) {
        String string = "XKC";

        boolean flag = check(string, o -> o.toLowerCase().equals("xkc"));

        if (flag) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

    }
}
