package com.xkc.learn.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String userName;
    private static String passWord;
    private static String driver;

    // 初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("web/src/main/java/com/xkc/learn/jdbc/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        url = properties.getProperty("url");
        userName = properties.getProperty("userName");
        passWord = properties.getProperty("passWord");
        driver = properties.getProperty("driver");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, passWord);
    }

    public static void close(Connection connection, Statement statement) {
        realse(connection, statement);
    }

    public static void close(ResultSet resultSet, Connection connection, Statement Statement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        realse(connection,Statement );
    }

    private static void realse(Connection connection, Statement Statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (Statement != null) {
            try {
                Statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
