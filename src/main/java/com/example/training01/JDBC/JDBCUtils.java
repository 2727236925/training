package com.example.training01.JDBC;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 抽取工具类
 */
public class JDBCUtils {
    private static final String driverClassName;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            driverClassName = bundle.getString("driverClassName");
            url = bundle.getString("url");
            username = bundle.getString("username");
            password = bundle.getString("password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {//加载驱动
        try {
            Class.forName(driverClassName);//登陆获取链接
            try {
                return DriverManager.getConnection(url,username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection conn=null;
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Zcl27272369250?");
//            System.out.println(conn);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return conn;
//    }
}
