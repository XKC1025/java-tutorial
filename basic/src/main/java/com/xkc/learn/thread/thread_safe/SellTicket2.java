package com.xkc.learn.thread.thread_safe;

/**
 * 使用同步方法:
 *  1.把访问了共享数据的代码块抽取出来, 放到一个单独的方法中
 *  2.方法上加上synchronized修饰符
 */
public class SellTicket2 implements Runnable {
    // 多线程共享的数据
    private int tickets = 1000;

    // 同步方法, 把方法内部的代码锁住, 任意时刻只能有一个线程执行
    // 锁对象就是this
    private synchronized void sell() {
        System.out.println("sell: " + this);

        if (tickets > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "售出: " + tickets--);
        }
    }

    @Override
    public void run() {
        while (true) {
            sell();

            Thread.yield();

            if (tickets <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 定义单个任务
        SellTicket2 sellTicket = new SellTicket2();

        System.out.println("sellTicket: " + sellTicket);

        // 分给三个线程去执行, 共享tickets变量
        Thread thread1 = new Thread(sellTicket);
        Thread thread2 = new Thread(sellTicket);
        Thread thread3 = new Thread(sellTicket);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
