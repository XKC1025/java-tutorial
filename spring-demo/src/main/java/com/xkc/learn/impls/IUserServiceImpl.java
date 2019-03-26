package com.xkc.learn.impls;

import com.xkc.learn.dao.IUserDao;
import com.xkc.learn.domain.User;
import com.xkc.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service("myService")
public class IUserServiceImpl implements IUserService {
    private String name;

    @Autowired
    private IUserDao iUserDao;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int addUser() {
        System.out.println("保存用户" + name);
        return 10;
    }

    @Override
    public void addUser(User user) {
        System.out.println("service 添加用户: " + user);

        // 调用Dao
        iUserDao.addUser(user);
    }

    public IUserServiceImpl() {
        System.out.println("创建IUserService对象");
    }

    public IUserDao getiUserDao() {
        return iUserDao;
    }

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }
}
