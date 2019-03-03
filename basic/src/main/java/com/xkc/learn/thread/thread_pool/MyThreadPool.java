package com.xkc.learn.thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java.util.concurrent.Executors
 * 线程池工厂类
 */
public class MyThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // 根据CPU核心数创建固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // 创建一个Runnable实现类
        // 调用executorService.submit()开启线程
        for (int j = 0; j < 6; j++) {
            executorService.submit(() -> {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "->" + i);
                }
            });
        }

        // 调用executorService.shutdown()销毁线程池, 不能继续添加任务  前面的队列任务会执行完毕
        executorService.shutdown();

        System.out.println("线程池结束!");
    }
}
