package com.xkc.learn.jdk8.method_reference;

public class ConstruceRef {
    private static Cat getCat(String name, CatBuilder<String> builder) {
        return builder.build(name);
    }

    public static void main(String[] args) {
        // 构造函数方法引用
        // int[]::new  数组构造方法引用
        Cat cat = getCat("XKC1025", Cat::new);

        System.out.println(cat);
    }
}

@FunctionalInterface
interface CatBuilder<T> {
    Cat build(T t);
}

class Cat {
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

