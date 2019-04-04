package com.xkc.learn.mybatis.domain;

import java.util.Date;

public class ItemModel {
    private Integer id;
    private String name;
    private Float price;
    private String detail;
    private String pio;
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPio() {
        return pio;
    }

    public void setPio(String pio) {
        this.pio = pio;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", pio='" + pio + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
