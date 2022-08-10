package com.example.training01.AopStudy.service.Impl;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Service("transInvocationHandler_cglib")
public class TransInvocationHandler_cglib implements InvocationHandler {

    @Resource(name = "UserService")
    private Object target;

    public Object getTarget() {
        return target;
    }

    @Resource(name = "txManager")
    private DataSourceTransactionManager manager;


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = manager.getTransaction(definition);
        String message = "执行成功，没有事务回滚";
        Object value=null;
        try{
            value=method.invoke(target,objects);//实行主要执行方法
            manager.commit(status);
        }
        catch (Exception e){
            e.printStackTrace();
            manager.rollback(status);
            message = "主键重复，事务回滚";
        }
        System.out.println(message);
        return value;
    }


}
