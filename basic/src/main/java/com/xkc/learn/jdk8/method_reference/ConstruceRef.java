package com.xkc.learn.jdk8.method_reference;

public class ConstruceRef {
    @FunctionalInterface
    interface CatBuilder<T> {
        Cat build(T t);
    }

    static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                "name='" + name + '\'' +
                '}';
        }
    }
    
    @FunctionalInterface
    interface ArrayInterface {
        int[] build(int length);
    }
    
    private static int[] buildArr(int length, ArrayInterface arrayInterface) {
        return arrayInterface.build(10);
    }
    
    private static Cat getCat(String name, CatBuilder<String> builder) {
        return builder.build(name);
    }

    public static void main(String[] args) {
        // 构造函数方法引用
        Cat cat = getCat("XKC1025", Cat::new);
        System.out.println(cat);
        
        // int[]::new  数组构造方法引用
        int[] myArr = buildArr(10, int[]::new);
        Stream.of(myArr).forEach(System.out::println);
    }
}





