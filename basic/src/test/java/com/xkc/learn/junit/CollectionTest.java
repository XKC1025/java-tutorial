package com.xkc.learn.junit;

import org.junit.Test;

public class CollectionTest {
    private static class A {
        @Override
        public String toString() {
            return "A{}";
        }
    }

    @Test
    public void castArray() {
        Object[] objects = {new A(), new A(), new A(), new A(), new A()};
        System.out.println(objects);

        System.out.println((A)objects[0]);
    }
}
