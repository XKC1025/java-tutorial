package com.xkc.learn.exception;

import java.io.FileNotFoundException;

public class MyException2 {
    private static void readFile(String fileName) throws FileNotFoundException {
        if (!fileName.equals("/home/a.txt")) {
            // 抛出编译期异常, 必须对异常进行处理
            // 本方法内处理不了, throws抛出给上层去处理  或者 try...catch...
            throw new FileNotFoundException("文件不存在");
        }
    }

    private static void readFile2(String fileName) {
        try {
            if (!fileName.equals("/home/a.txt")) {
                // 本方法内可以对异常进行处理, 不用throws抛给上层
                throw new FileNotFoundException("文件不存在");

            }
        } catch (FileNotFoundException e) {
            // 异常简短信息
            System.out.println(e.getMessage());

            // 异常详细信息
            System.out.println(e);

            // 异常调用栈
            e.printStackTrace();
        } finally {
            System.out.println("一定会执行的代码");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("/home/a.tx");

        readFile2("/home/a.tx");
    }
}
