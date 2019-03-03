package com.xkc.learn.thread.thread_safe;

/**
 * synchronized(锁对象) {可能会出现线程安全问题的代码}
 *
 * 注意:
 *     1.通过代码块中的锁对象, 可以使用任意的对象
 *     2.保证多个线程使用的是同一个锁对象
 *     3.锁对象把同步代码块锁定住, 任意时刻只能有一个线程进入同步代码块
 */
public class SellTicket implements Runnable {
    // 多线程共享的数据
    private int tickets = 10000;

    // 全局锁对象, 必须定义在run()方法外面
    // Object obj = new Object()

    @Override
    public void run() {
        while (true) {
            // 任意时刻只能有一个线程进入同步代码块, 其他线程处于阻塞状态
            // 同步中的线程没有执行完不会释放锁, 同步外的线程没有锁进不去同步代码块
            // synchronized(obj)  使用全局锁对象
            synchronized(this) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "售出: " + tickets--);

                }

                Thread.yield();

                if (tickets <= 0) {
                    break;
                }
            }
            // 出了同步代码块, 会把锁对象归还, 多线程抢夺锁对象
        }
    }

    public static void main(String[] args) {
        // 定义单个任务
        SellTicket sellTicket = new SellTicket();

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
