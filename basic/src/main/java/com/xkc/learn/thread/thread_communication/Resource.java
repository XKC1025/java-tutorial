package com.xkc.learn.thread.thread_communication;

public class Resource {
    String pi;
    String xian;

    boolean flag = false;

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "pi='" + pi + '\'' +
                ", xian='" + xian + '\'' +
                '}';
    }
}
