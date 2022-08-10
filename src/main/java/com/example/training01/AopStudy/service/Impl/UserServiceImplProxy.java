package com.example.training01.AopStudy.service.Impl;

import com.example.training01.AopStudy.domain.t_User;
import com.example.training01.AopStudy.entity.Operation;
import com.example.training01.AopStudy.service.UserService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

@Service("UserServiceProxy")
public class UserServiceImplProxy implements UserService {

    @Resource(name = "UserService")
    private UserService userService;

    @Resource(name = "txManager")
    private DataSourceTransactionManager manager;
//    @Resource(name = "myTransManager")
//    private MyTransManager myTransManager;
    @Override
    public void UserUpdate(t_User t_user, Operation operation) {
        System.out.println("执行代理方法");
//        try{
//            myTransManager.startTrans();
//            userService.UserUpdate(t_user,operation);
//            myTransManager.Commit();
//        }catch (Exception e){
//            try {
//                myTransManager. rollback ();}
//            catch (SQLException e1){
//                e1.printStackTrace() ;
//            }
//        }
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = manager.getTransaction(definition);
        String message = "执行成功，没有事务回滚";
        try
        {
            userService.UserUpdate(t_user,operation);
            manager.commit(status);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            manager.rollback(status);
            message = "主键重复，事务回滚";
        }
        System.out.println(message);
    }
}
