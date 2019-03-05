package com.xkc.learn.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型?通配符, 用于方法的参数
 */
public class WildCard {
    // 泛型的使用, 此时可能会增加集合的元素
    private static <T> void print(List<T> lists) {
        for (T t : lists) {
            System.out.println(t);
        }
    }

    // 通配符的使用, 此时集合的元素不能添加
    private static void newPrint(List<?> lists) {
        // 使用迭代器进行遍历
        Iterator<?> iterator = lists.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(3);
        ints.add(4);

        ArrayList<String> strs = new ArrayList<>();
        strs.add("X");
        strs.add("K");
        strs.add("C");

        print(ints);
        print(strs);

        newPrint(ints);
        newPrint(strs);

    }
}
