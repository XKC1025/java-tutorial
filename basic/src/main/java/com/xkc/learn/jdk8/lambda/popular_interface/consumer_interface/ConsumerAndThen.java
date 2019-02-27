package com.xkc.learn.jdk8.lambda.popular_interface.consumer_interface;

import java.util.function.Consumer;

/**
 * Consumer接口的默认方法andThen():
 *      将两个Consumer接口组合到一起, 依次对数据进行消费
 *
 *      eg.
 *          Consumer<String> con1
 *          Consumer<String> con2
 *          String s = "Hello";
 *          // 依次消费
 *          con1.accept(s);
 *          con2.accept(s);
 *
 *          // 优化  con1先消费
 *          con1.andThen(con2).accept(s);
 */
public class ConsumerAndThen {
    private static void consumer(String s, Consumer<String> con1, Consumer<String> con2) {
        con1.accept(s);
        con2.accept(s);

        // andThen()默认方法
        con1.andThen(con2).andThen(o -> System.out.println("xkc" + s)).accept(s);
    }

    public static void main(String[] args) {
        consumer("XKC", System.out::println, o -> System.out.println(o + 1025));
    }
}
