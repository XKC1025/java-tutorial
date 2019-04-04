package com.xkc.learn.mybatis.vo;

import com.xkc.learn.mybatis.domain.OrderModel;

public class OrdersExt extends OrderModel {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrdersExt{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}' + "\n" +super.toString();
    }
}
