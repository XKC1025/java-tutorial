package com.xkc.learn.jdbc_template;

import com.xkc.learn.connection_pool.druid.DruidUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class MyJdbcTemplate {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Test
    public void testUpdate() {
        // 执行DML
        String SQL = "UPDATE orders SET money = ? WHERE id = ?";
        int count = template.update(SQL, 10000, 1);

        System.out.println(count);

    }

    @Test
    public void testDelete() {
        String SQL = "DELETE FROM orders WHERE id = ?";
        int count = template.update(SQL, 100);

        System.out.println(count);
    }

    @Test
    public void testInsert() {
        String SQL = "INSERT orders VALUE (null, ?, ?, ?)";
        int count = template.update(SQL, 11111, 22222, 33333);

        System.out.println(count);
    }

    @Test
    public void testMap() {
        // 将查询结果封装成Map
        String SQL = "SELECT * FROM orders WHERE id = ?";

        Map<String, Object> map = template.queryForMap(SQL, 1);

        // {id=1, user_id=1000, money=10000, create_time=111}
        System.out.println(map);
    }

    @Test
    public void testList() {
        // 将查询结果封装成List
        String SQL = "SELECT * FROM orders WHERE id > ?";

        List<Map<String, Object>> maps = template.queryForList(SQL, 1);

        // {id=1, user_id=1000, money=10000, create_time=111}
        System.out.println(maps);
    }

    @Test
    public void testBean() {
        // 将查询结果封装成JavaBean
        String SQL = "SELECT * FROM orders WHERE id > 10";

        List<Emp> emps = template.query(SQL, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();

                emp.setId(resultSet.getInt(1));
                emp.setUser_id(resultSet.getInt(2));
                emp.setMoney(resultSet.getInt(3));
                emp.setCreate_time(resultSet.getInt(4));

                return emp;
            }
        });

        System.out.println(emps);
    }

    @Test
    public void testBeanModify() {
        // 将查询结果封装成JavaBean
        String SQL = "SELECT * FROM orders WHERE id > 1";

        List<Emp> emps = template.query(SQL, new BeanPropertyRowMapper<>(Emp.class));

        System.out.println(emps);
    }

    @Test
    public void testCount() {
        // 将查询结果封装成Object
        // 执行聚合函数
        String SQL = "SELECT count(id) FROM orders";

        Long count = template.queryForObject(SQL, long.class);

        System.out.println(count);
    }
}
