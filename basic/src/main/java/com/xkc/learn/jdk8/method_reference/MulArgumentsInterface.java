package com.xkc.learn.jdk8.method_reference;

@FunctionalInterface
public interface MulArgumentsInterface<T, K> {
     T add(T a, K b);
}
