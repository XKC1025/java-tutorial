package com.xkc.learn.mybatis.vo;

import com.xkc.learn.mybatis.domain.OrderModel;
import com.xkc.learn.mybatis.domain.UserModel;

/**
 * 复杂条件查询包装类
 */
public class UserQueryVO {
    private UserModel user;
    private OrderModel order;

    public UserQueryVO() {
    }

    public UserQueryVO(UserModel user, OrderModel order) {
        this.user = user;
        this.order = order;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }
}
