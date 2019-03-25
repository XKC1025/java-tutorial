package com.xkc.learn.impls;

import com.xkc.learn.dao.IUserDao;
import com.xkc.learn.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class IUserDaoImpl implements IUserDao {
    @Override
    public void addUser(User user) {
        System.out.println("dao 添加用户: " + user);
    }
}
