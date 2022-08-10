package com.example.training01.AopStudy.util;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

/**
 * 事务管理器
 */
@Service("myTransManager")
@Aspect
@Order(2)
public class MyTransManager {
    @Resource(name = "txManager")
    private DataSourceTransactionManager manager;

    private TransactionStatus status=null;

    @Pointcut("execution(* com.example.training01.AopStudy.service.Impl.UserServiceImpl.UserUpdate(..))")
    public void pointCut(){

    }

    //开启事务
    @Before("pointCut()")
    public TransactionStatus startTrans(){
        System.out.println("建立连接");
        TransactionDefinition definition = new DefaultTransactionDefinition();
        this.status = manager.getTransaction(definition);
        return status;
    }

    //提交
    @AfterReturning("pointCut()")
    public void Commit() {
        System.out.println("没有问题，提交");
        manager.commit(status);
    }

    //回滚操作
    @AfterThrowing("pointCut()")
    public void rollback() {
        System.out.println("有问题，回滚");
        manager.rollback(status);
    }

}
//代理模式 静态代理 动态代理
//业务层强化功能
