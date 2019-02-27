package com.xkc.learn.jdk8.lambda.logger_demo;

/**
 * 性能浪费, 使用lambda进行性能优化
 * lambda特点: 延迟加载
 * lambda使用前提: 必须有函数式接口
 */

public class Logger {
    private static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "java";

        // level等级不是1, 字符串拼接会导致性能浪费
        log(1, msgA + msgB + msgC);
    }
}
