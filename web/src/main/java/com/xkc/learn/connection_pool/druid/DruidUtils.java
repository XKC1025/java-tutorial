package com.xkc.learn.connection_pool.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类提供:
 * 1.获取Connection
 * 2.释放资源
 * 3.获取连接池
 */
public class DruidUtils {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();

        // 获取配置文件流对象
        InputStream resourceAsStream = DruidUtils.class.getResourceAsStream("druid.properties");

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 连接池加载配置文件
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(Statement statement, Connection connection) {
        release(statement, connection);
    }

    private static void release(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        release(statement, connection);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
