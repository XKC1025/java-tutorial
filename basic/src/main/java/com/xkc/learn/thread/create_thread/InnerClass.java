package com.xkc.learn.thread.create_thread;

/**
 * 匿名内部类的方式实现线程
 *
 *  new Thread() / Runnable() {执行代码}.start();
 */
public class InnerClass {

    public static void main(String[] args) {
        // 继承Thread内部类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
            }
        }.start();

        // 实现Runnable接口
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " - " + i);
                }
            }
        }).start();

        // lambda表达式简化Runnable实现
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        }).start();
    }
}
