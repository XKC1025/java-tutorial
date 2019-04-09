package com.xkc.learn.thread.thread_communication;

public class Producer extends Thread {
    private Resource resource;

    private static int count = 0;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        // 必须使用同步机制, 保证两个线程只能有一个在执行
        while (true) {
            synchronized (resource) {
                // 对资源锁对象进行判断
                if (resource.flag) {
                    try {
                        // 使当前线程进入WAITING状态
                        // 代码不会往下执行
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 被唤醒之后, 从此处继续执行
                if (count % 2 == 0) {
                    resource.pi = "薄皮";
                    resource.xian = "三鲜";
                } else {
                    resource.pi = "冰皮";
                    resource.xian = "牛肉";
                }

                count++;
                System.out.println("Producer正在生产: " + resource);

                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 修改资源状态
                resource.flag = true;

                // 唤醒consumer线程
                resource.notifyAll();

            }
        }
    }
}
