package com.xkc.learn.jdk8.method_reference;

import java.util.function.Consumer;

public class SuperMethodRef {
    @FunctionalInterface
    interface Greetable {
        void greet();
    }

    static class Person {
        void sayHello() {
            System.out.println("I'm Person");
        }
    }

    static class Man extends Person {
        @Override
        void sayHello() {
            System.out.println("I'm Man");
        }

        void method(Greetable greetable) {
            greetable.greet();
        }

        void consumer(String string, Consumer<String> con) {
            con.accept(string);
        }

        void foo(String string) {
            System.out.println("self method " + string);
        }

        void show() {
            // 通过super引用父类的方法
            method(super::sayHello);

            // 通过this引用自身的方法
            consumer("XKC", this::foo);
        }
    }


    public static void main(String[] args) {
        new Man().show();
    }
}
