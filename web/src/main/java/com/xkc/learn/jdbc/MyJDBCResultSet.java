package com.xkc.learn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 封装重复代码
 */
@SuppressWarnings("all")
public class MyJDBCResultSet {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

//            statement = connection.createStatement();

            // 结果集对象, 类似于游标, 返回时执行字段名, 调用next()方法向下移动一行
            // 指定字段编号(1开始) / 字段名来获取游标所在行的值
//            resultSet = statement.executeQuery("SELECT * FROM orders");

            // 使用预编译防止SQL注入
            // 使用?作为占位符
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE id > ? AND money = ?");

            // 给?赋值
            preparedStatement.setInt(1, 5);
            preparedStatement.setInt(2, 9999);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getInt(2));
                System.out.println(resultSet.getInt("money"));
                System.out.println("===============================================");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, connection, statement);
        }
    }
}

