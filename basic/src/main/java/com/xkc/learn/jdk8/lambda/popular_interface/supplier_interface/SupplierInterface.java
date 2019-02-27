package com.xkc.learn.jdk8.lambda.popular_interface.supplier_interface;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Supplier接口:
 *      生产型接口, 指定接口的泛型, get()方法就会生产对应类型的数据
 */
public class SupplierInterface {
    private static <T> T getElement(Supplier<T> supplier) {
        return supplier.get();
    }

    /**
     * @param supplier
     * @return 求最大值
     */
    private static Integer getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String result = getElement(() -> {
            // 生产一个字符串, 并返回
            return "XKC";
        });

        System.out.println(result);

        Integer[] ints = {1, 3, 5, 7, 9, 11, 100, 13, 1000, 15, 17, 19, 21};
        Random random = new Random(47);

        int number = getElement(() -> ints[random.nextInt(ints.length - 1)]);
        System.out.println(number);

        // 求最大值
        int max = getMax(() -> {
            Arrays.sort(ints, (o1, o2) -> o2 - o1);
            return ints[0];
        });

        System.out.println(max);
    }
}
