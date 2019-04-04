package com.xkc.learn.mybatis.dao;

import com.xkc.learn.mybatis.domain.UserModel;
import com.xkc.learn.mybatis.vo.OrdersExt;
import com.xkc.learn.mybatis.vo.OrdersVO;

import java.util.List;

public interface OrderMapper {
    OrdersExt findOrderExtById(int id);

    OrdersVO findOrderVOById(int id);

    List<OrdersVO> findOrderDetailById(int id);

    List<UserModel> findUserAndOrder(int id);
}
