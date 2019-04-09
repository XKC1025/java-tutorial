package com.xkc.learn.enums;

public enum Person {
    P1(1, "1"),
    P2(2, "2");

    // 枚举键值对
    private Integer key;
    private String value;

    // 枚举构造函数
    Person(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    // 枚举getter / setter 方法
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
