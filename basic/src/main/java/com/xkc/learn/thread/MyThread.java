package com.xkc.learn.thread;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

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
        // 对线程指定名称
        MyThread myThread = new MyThread("My thread");

        // 覆盖初始化的名称
        myThread.setName("sub thread");
        myThread.start();

        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("main" + i);
            Thread.yield();
        }
    }
}
