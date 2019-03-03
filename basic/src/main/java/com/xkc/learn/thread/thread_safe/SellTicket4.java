package com.xkc.learn.thread.thread_safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁:
 *      Lock接口  lock()和unlock()方法
 *
 *      1.创建ReentrantLock()成员变量
 *      2.在可能会出现安全问题的代码前调用Lock.lock()方法
 *      3.在可能会出现安全问题的代码后调用Lock.unlock()方法
 *      4.用try..finally...保证一定释放锁
 */
public class SellTicket4 implements Runnable {
    // 多线程共享的数据
    private int tickets = 10000;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 访问共享变量前获取锁对象
            lock.lock();

            try {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "售出: " + tickets--);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Thread.yield();

                // 一定要释放锁对象
                lock.unlock();

                if (tickets <= 0) {
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        // 定义单个任务
        SellTicket4 sellTicket = new SellTicket4();

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
