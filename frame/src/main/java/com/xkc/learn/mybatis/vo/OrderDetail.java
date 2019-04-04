package com.xkc.learn.mybatis.vo;

import com.xkc.learn.mybatis.domain.ItemModel;

public class OrderDetail {
    private Integer id; // 订单详情id
    private Integer items_id; // 商品id
    private Integer items_num; //商品数量

    private ItemModel item; // 商品详情

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItems_id() {
        return items_id;
    }

    public void setItems_id(Integer items_id) {
        this.items_id = items_id;
    }

    public Integer getItems_num() {
        return items_num;
    }

    public void setItems_num(Integer items_num) {
        this.items_num = items_num;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", items_id=" + items_id +
                ", items_num=" + items_num +
                ", item=" + item +
                '}';
    }
}
