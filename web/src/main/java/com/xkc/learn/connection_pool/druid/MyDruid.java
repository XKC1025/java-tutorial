package com.xkc.learn.connection_pool.druid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 阿里云数据库连接池
 */
public class MyDruid {
    public static void main(String[] args) throws Exception {
        // 获取连接
        Connection connection = DruidUtils.getConnection();

        System.out.println(DruidUtils.getDataSource());

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt((1)));
            System.out.println("=====================================");
        }

        // 归还连接对象
        DruidUtils.close(resultSet, statement, connection);

        System.out.println(DruidUtils.getDataSource());
    }
}
