package com.xkc.learn.thread.thread_communication;

public class Consumer extends Thread {
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                // 判断资源状态
                if (!resource.flag) {
                    try {
                        // 无资源, 当前线程进入等待状态
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 当前线程被唤醒之后, 从此处开始执行
                System.out.println("consumer1: " + resource);
                resource.flag = false;

                // 唤醒Producer
                resource.notify();

            }
        }
    }
}
