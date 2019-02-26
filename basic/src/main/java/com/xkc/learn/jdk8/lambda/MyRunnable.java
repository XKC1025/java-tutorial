package com.xkc.learn.jdk8.lambda;

public class MyRunnable {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();

        // 创建Thread对象
        Thread thread = new Thread(runnable);
        thread.start();

        // 使用匿名局部内部类, 实现多线程
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程又创建了!");

            }
        });
        thread2.start();

        // Runnable实现类, 匿名局部内部类, @Override, run()方法都是冗余的
        // 只有run()方法体才是真正需要的, 所以用Lambda简化
        // Lambda表达式: (接口中唯一的抽象方法参数列表) -> {重写接口抽象方法的代码}
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "新线程又创建了!")).start();
    }
}
