package com.xkc.learn.mybatis.domain;

import com.xkc.learn.mybatis.vo.OrderDetail;

import java.util.Date;
import java.util.List;

public class OrderModel {
    private Integer id;
    private Integer user_id;
    private Integer money;
    private Date create_time;
    private String note;
    private UserModel user;
    private List<OrderDetail> details;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", money=" + money +
                ", create_time=" + create_time +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", details=" + details +
                '}';
    }
}
