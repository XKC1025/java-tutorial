package com.xkc.learn.impls;

import com.xkc.learn.dao.IUserDao;
import com.xkc.learn.domain.User;
import com.xkc.learn.jdbc_template.Emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.List;


/**
 * 可以继承JdbcDaoSupport, 调用getJdbcTemplate()获得jdbcTemplate对象
 *
 * xml文件, 通过setter方法注入dataSource
 */
@Repository
public class IUserDaoImpl2 extends JdbcDaoSupport implements IUserDao {

    @PostConstruct    // 相当于xml配置文件init-method
    public void myInit() {
        System.out.println("IUserDaoImpl Bean 初始化方法");
    }

    @Override
    public void addUser(User user) {
        System.out.println("dao 添加用户: " + user);

        getJdbcTemplate().update("INSERT orders VALUE(?, ?, ?, ?)", null, 4, 5000, new Date());

        List<Emp> emps = getJdbcTemplate().query("SELECT * FROM orders WHERE id > 1", new BeanPropertyRowMapper<>(Emp.class));

        System.out.println(emps);
    }

    @PreDestroy      // 相当于xml配置文件destroy-method
    public void myDestroy() {
        System.out.println("IUserDaoImpl Bean 销毁方法");
    }
}
