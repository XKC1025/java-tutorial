package com.xkc.learn.jdk8.method_reference;

@FunctionalInterface
public interface Printable<T> {
    void print(T t);
}
