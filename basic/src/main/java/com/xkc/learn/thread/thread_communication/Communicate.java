package com.xkc.learn.thread.thread_communication;

public class Communicate {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        producer.start();
        consumer.start();
    }
}
