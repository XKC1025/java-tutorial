package com.xkc.learn.impls;

import com.xkc.learn.dao.IUserDao;
import com.xkc.learn.domain.User;
import com.xkc.learn.jdbc_template.Emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.List;


@Repository
public class IUserDaoImpl implements IUserDao {
    // 注入JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct    // 相当于xml配置文件init-method
    public void myInit() {
        System.out.println("IUserDaoImpl Bean 初始化方法");
    }

    @Override
    public void addUser(User user) {
        System.out.println("dao 添加用户: " + user);

        jdbcTemplate.update("INSERT orders VALUE(?, ?, ?, ?)", null, 4, 5000, new Date());

        List<Emp> emps = jdbcTemplate.query("SELECT * FROM orders WHERE id > 1", new BeanPropertyRowMapper<>(Emp.class));

        System.out.println(emps);
    }

    @PreDestroy      // 相当于xml配置文件destroy-method
    public void myDestroy() {
        System.out.println("IUserDaoImpl Bean 销毁方法");
    }
}
