package com.xkc.learn.jdk8.lambda.popular_interface.predicate_interface;

import java.util.function.Predicate;

/**
 * 默认方法and():
 *      多个判断条件同时满足
 *
 *      or()
 *      只要有一个满足
 *
 *      negate()
 *      取反
 */
public class UseAnd {
    private static boolean and(String string, Predicate<String> pre1, Predicate<String> pre2) {
        // 取反
        // return pre1.negate().test(string);
        return pre1.or(pre2).test(string);
    }

    public static void main(String[] args) {
        String name = "xukechen";

        boolean result = and(name, o -> name.length() > 5, m -> m.contains("xX"));

        if (result) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        boolean bool = Predicate.isEqual("XKC").test("XKC");
        System.out.println(bool);
    }
}
