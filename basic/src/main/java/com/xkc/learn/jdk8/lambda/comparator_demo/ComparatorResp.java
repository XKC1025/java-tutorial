package com.xkc.learn.jdk8.lambda.comparator_demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 如果一个方法的返回值是一个函数式接口, 那么就可以直接返回一个lambda表达式
 * <p>
 * 实际上是返回接口的匿名内部类, 可以用lambda优化
 */

public class ComparatorResp {
    /**
     * @return Comparator<T> 返回值是一个函数式接口
     */
    private static Comparator<String> getComparator() {
        /*
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };
        */

        // 使用lambda优化匿名内部类
        return (o1, o2) -> o2.length() - o1.length();
    }

    public static void main(String[] args) {
        String[] strings = {"aaa", "bbbb", "c", "dd"};

        // Comparator<String> comparator = (o1, o2) -> o2.length() - o1.length();
        Arrays.sort(strings, getComparator());

        System.out.println(Arrays.toString(strings));
    }
}
