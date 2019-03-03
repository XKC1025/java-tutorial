package com.xkc.learn.thread.thread_safe;

/**
 * 静态同步方法:
 *      锁对象是 SellTicket3.class
 */
public class SellTicket3 implements Runnable {
    // 多线程共享的数据
    private static int tickets = 1000;

    /**
     * 静态同步方法
     */
    private synchronized static void sell() {
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
        SellTicket3 sellTicket = new SellTicket3();

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
