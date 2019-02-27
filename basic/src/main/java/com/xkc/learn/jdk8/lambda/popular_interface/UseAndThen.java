package com.xkc.learn.jdk8.lambda.popular_interface;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 使用Consumer接口的andThen()方法, 格式化输出信息
 */
public class UseAndThen {
    private static void consumer(String[] infos, Consumer<String> con1, Consumer<String> con2) {
        for (String info : infos) {
            con1.andThen(con2).accept(info);
        }
    }

    public static void main(String[] args) {
        String[] infos = {"迪丽热巴, 女", "古力娜扎, 女", "马尔扎哈, 男"};

        consumer(infos,
                (o) -> System.out.print("姓名: " + o.substring(0, o.length() - 3) + "    "),
                (o) -> System.out.println("性别: " + o.charAt(o.length() - 1)));

    }
}
