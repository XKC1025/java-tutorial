package com.xkc.learn.thread.create_thread;

import static java.lang.Thread.sleep;

/**
 * 实现Runnable接口的好处:
 *      1.避免了单继承的局限性
 *      2.可以实现多个接口, 增强程序的扩展性   传递不同的Runnable实现类, 执行不同的线程任务
 *      3.继承只能执行单一的线程任务, 不同的任务需要创建不同的实现类
 */
public class MyRunnable implements Runnable {

    // 重写run()方法, 用来设置本线程的执行任务
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread()  获取当前执行线程的引用
            System.out.println(Thread.currentThread().getName() + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "Runnable");

        // 覆盖初始化线程名
        thread.setName("My Runnable");

        thread.start();

        System.out.println(Thread.currentThread().getName());
    }
}
