package com.xkc.learn.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 获取Stream流对象
 *      1.Collection.Stream()
 *      2.Stream.of()
 */
public class GetStream {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        // 集合内置函数
        Stream<String> stream = strings.stream();

        // Stream接口的静态方法
        Stream<String> stream2 = Stream.of("AA", "BB", "CC", "DD");

        // Arrays.stream() 集合静态方法
        int[] ints = {1, 2, 3, 4, 5, 6};
        IntStream intStream = Arrays.stream(ints);

    }
}
