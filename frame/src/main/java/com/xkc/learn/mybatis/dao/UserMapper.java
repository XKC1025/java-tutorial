package com.xkc.learn.mybatis.dao;

import com.xkc.learn.mybatis.domain.OrderModel;
import com.xkc.learn.mybatis.domain.UserModel;
import com.xkc.learn.mybatis.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    UserModel findUserById(int id);

    List<UserModel> findUserByUserName(String username);

    int insertUser(UserModel user);

    int deleteUser(String username);

    int updateUser(UserModel user);

    int getPrimaryKey1(UserModel user);

    List<UserModel> findByUserQueryVO(UserQueryVO queryVO);

    List<UserModel> findByMap(Map<String, Object> map);

    int findUserCount();

    UserModel findByResultMap(int id);

    List<UserModel> findByIfWhere(UserQueryVO queryVO);

    List<UserModel> findByForEach(UserQueryVO ids);

    List<UserModel> findByForEach2(List<Integer> ids);

    // 懒加载
    List<OrderModel> findOrderAndUserByLazyLoading();
}
