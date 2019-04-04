package com.xkc.learn.mybatis.vo;

import com.xkc.learn.mybatis.domain.OrderModel;
import com.xkc.learn.mybatis.domain.UserModel;

import java.util.List;

/**
 * 复杂条件查询包装类
 */
public class UserQueryVO {
    private UserModel user;
    private OrderModel order;
    private List<Integer> ids;

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

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
