package com.xkc.learn.reflection.practice;

import java.lang.reflect.Method;

public class TestCalc {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = Calculator.class;

        Object o = clazz.newInstance();

        Method[] methods = clazz.getDeclaredMethods();

        int count = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(o);
                } catch(Exception e) {
                    count++;
                    System.out.println(method.getName() + "出现异常");
                }
            }
        }
    }
}
