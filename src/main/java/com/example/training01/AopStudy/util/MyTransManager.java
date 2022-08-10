package com.example.training01.Real_Study.util;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务管理器
 */
@Service("myTransManager")
public class MyTransManager {
    @Resource(name = "druidDataSource")
    private DataSource druidDataSource;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    public Connection getConn() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn !=null){
            return conn;
        }
        conn = druidDataSource.getConnection();
        threadLocal.set(conn);
        return conn;
    }

    //开启事务
    public void startTrans() throws SQLException {
        getConn().setAutoCommit(false);
    }

    //提交
    public void Commit() throws SQLException {
        getConn().commit();
    }

    //回滚操作
    public void rollback() throws SQLException {
        getConn().rollback();
    }

}
//代理模式 静态代理 动态代理
//业务层强化功能
