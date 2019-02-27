package com.xkc.learn.jdk8.lambda.popular_interface.consumer_interface;

import java.util.function.Consumer;

/**
 * Consumer接口:
 *      消费型接口, 指定接口的泛型, accept()方法就会消费对应类型的数据
 */
public class ConsumerInterface {
    /**
     * 消费String数据
     * @param string
     * @param consumer
     */
    private static void consumer(String string, Consumer<String> consumer) {
        consumer.accept(string);
    }

    public static void main(String[] args) {
        consumer("xkc", o -> System.out.println(o));

        // 方法引用优化lambda表达式
        consumer("XKC", System.out::println);
    }
}
