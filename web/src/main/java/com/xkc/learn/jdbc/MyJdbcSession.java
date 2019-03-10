package com.xkc.learn.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC事务默认开启
 *      connection.setAutoCommit(false) 关闭自动提交
 */
public class MyJdbcSession {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        // 必须手动提交事务
        // 执行SQL之前开启事务
        connection.setAutoCommit(false);

        String sql1 = "UPDATE orders SET money = ? WHERE id = ?";
        String sql2 = "UPDATE orders SET money = ? WHERE id = ?";

        PreparedStatement pre1 = connection.prepareStatement(sql1);
        PreparedStatement pre2 = connection.prepareStatement(sql2);

        pre1.setInt(1, 500);
        pre1.setInt(2, 1);

        pre2.setInt(1, 2500);
        pre2.setInt(2, 2);



        try {
            pre1.executeUpdate();

            int restult = 3 / 0;

            pre2.executeUpdate();

            // 提交本次事务
            // 当所有的SQL都执行完提交事务
            connection.commit();
        } catch (Exception e) {
            // 出现异常, 回滚事务
            connection.rollback();
        } finally {
            // 释放资源
        }
    }
}
