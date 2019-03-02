package com.xkc.learn.annotation;

import com.xkc.learn.enums.Person;

public @interface MyAnno {
    // 定义常量
    String desc = "How to use annoation";

    // 抽象方法称为注解的属性
    public abstract String show();

    int age();

    Person p();

    String[] strs();

    MyAnno2 anno();

    // 默认值
    boolean flag() default true;
}
