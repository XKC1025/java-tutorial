package com.xkc.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 */
@SuppressWarnings("all")
public class MyJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 注册驱动, 默认自动注入, 注册驱动可省略
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 获得连接对象
            // 连接本机MySQL服务器, url可简写jdbc:mysql:///test
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC&userSSL=false", "root", "189546");

            // 获得执行SQL对象
            statement = connection.createStatement();

            // executeUpdate()执行SQL, 返回影响的行数
            int row = statement.executeUpdate("INSERT orders VALUE(NULL, 50, 9999, 2019-03-08)");

            //executeQuery()返回结果集对象
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            // 获取执行结果
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
