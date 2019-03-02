package com.xkc.learn.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class MyException {
    private static void exceptions() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 编译期异常
        Date date = null;
        try {
            date = simpleDateFormat.parse("1996-10-22500");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);

        // 运行期异常
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (RuntimeException e) {
            // 异常的处理逻辑
            e.printStackTrace();
        }
        System.out.println("运行期异常");

        // Error错误  java.lang.OutOfMemoryError
        // 内存溢出, 必须修改代码, 否则错误会一直存在
        try {
            // int[] arr2 = new int[1024 * 1024 * 1024];
            int[] arr2 = new int[1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getElement(int[] arr, int index) {
        // 对传入的参数进行合法性校验
        Objects.requireNonNull(arr);

        if (index < 0 || index > arr.length) {
            // RuntimeException可以不处理, 交给JVM处理
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }

        // 1.产生异常, JVM创建一个异常对象, 抛给main()方法去处理
        return arr[index];
    }

    public static void main(String[] args) {
        // exceptions();

        // 2.main()方法无法处理, 抛给JVM
        // 3.JVM把异常信息输出在控制台, 并终止程序
        int element = getElement(new int[]{1, 2, 3}, 1);
        System.out.println(element);
    }
}
