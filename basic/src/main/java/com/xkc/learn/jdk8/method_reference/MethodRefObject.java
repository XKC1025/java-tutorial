package com.xkc.learn.jdk8.method_reference;

public class MethodRefObject {
    private static void print(String string, Printable<String> printable) {
        printable.print(string);
    }

    public static void main(String[] args) {
        MethodRefObjectUse methodRefObjectUse = new MethodRefObjectUse();

        // 通过实例化对象, 引用实例方法
        print("xu ke chen", methodRefObjectUse::printUpperCase);
    }
}

class MethodRefObjectUse {
    void printUpperCase(String string) {
        System.out.println(string.toUpperCase());
    }

}
