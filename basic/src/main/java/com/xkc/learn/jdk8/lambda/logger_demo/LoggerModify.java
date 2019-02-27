package com.xkc.learn.jdk8.lambda.logger_demo;

/**
 * 使用lambda进行性能优化
 */

public class LoggerModify {
    private static void log(int level, MessageBuilder msgB) {
        if (level == 1) {
            // 延迟执行lambda方法体
            String log = msgB.builderMsg();
            System.out.println(log);
        }

    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "java";

        // 仅仅是把参数传递到log()方法内
        // 字符串拼接延迟计算, 提升性能
        log(1, () -> msgA + msgB + msgC);
    }

}
