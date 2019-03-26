package com.xkc.learn.impls;

import com.xkc.learn.dao.IUserDao;
import com.xkc.learn.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
public class IUserDaoImpl implements IUserDao {
    @PostConstruct    // 相当于xml配置文件init-method
    public void myInit() {
        System.out.println("IUserDaoImpl Bean 初始化方法");
    }

    @Override
    public void addUser(User user) {
        System.out.println("dao 添加用户: " + user);
    }

    @PreDestroy      // 相当于xml配置文件destroy-method
    public void myDestroy() {
        System.out.println("IUserDaoImpl Bean 销毁方法");
    }
}
