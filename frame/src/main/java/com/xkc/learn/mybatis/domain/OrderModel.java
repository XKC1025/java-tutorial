package com.xkc.learn.mybatis.domain;

import java.util.Date;

public class OrderModel {
    private Integer id;
    private Integer user_id;
    private Integer money;
    private Date create_time;

    public OrderModel() {
    }

    public OrderModel(Integer id, Integer user_id, Integer money, Date create_time) {
        this.id = id;
        this.user_id = user_id;
        this.money = money;
        this.create_time = create_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
