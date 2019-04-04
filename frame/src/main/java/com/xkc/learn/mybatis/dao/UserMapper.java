package com.xkc.learn.mybatis.dao;

import com.xkc.learn.mybatis.domain.UserModel;
import com.xkc.learn.mybatis.vo.UserQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    UserModel findUserById(@Param("id") int id);

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
}
