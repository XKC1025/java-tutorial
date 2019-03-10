package com.xkc.learn.jdbc_template;

public class Emp {
    private Integer id;
    private Integer user_id;
    private Integer money;
    private Integer create_time;

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

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", money=" + money +
                ", create_time=" + create_time +
                '}';
    }
}
