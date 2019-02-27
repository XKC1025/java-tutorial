package com.xkc.learn.jdk8.lambda.runnable_demo;

/**
 *  实现Runnable接口
 */

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "新线程创建了!");
    }
}
