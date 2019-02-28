package com.xkc.learn.jdk8.stream;

import java.util.ArrayList;
import java.util.List;

public class ListStream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("周芷若");
        names.add("赵敏");
        names.add("段誉");
        names.add("张三丰");

        // 筛选元素
        names.stream().filter(o -> o.startsWith("张")).forEach(System.out::println);
        names.stream().filter(o -> o.length() == 2).forEach(System.out::println);
    }
}
