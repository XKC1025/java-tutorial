package com.xkc.learn.jdk8.lambda.popular_interface.predicate_interface;

import java.util.function.Predicate;

/**
 * 筛选集合中的信息
 */

public class CollectionsFilter {
    private static void filter(String[] infos, Predicate<String> pre1, Predicate<String> pre2) {
        for (String info : infos) {
            boolean flag = pre1.and(pre2).test(info);
            if (flag) {
                System.out.println(info);
            }
        }

    }

    public static void main(String[] args) {
        String[] infos = {"迪丽热巴, 女", "古力娜扎, 女", "马尔扎哈, 男", "赵丽颖, 女"};

        filter(infos, o->o.substring(0, o.length()-3).length() == 4, o->o.substring(o.length()-1).equals("女"));

    }
}
