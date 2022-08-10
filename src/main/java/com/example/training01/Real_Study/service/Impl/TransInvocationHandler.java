package com.example.training01.Real_Study.service.Impl;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
*事务管理增强的一个模板
*事务管理增强的工具类
* ————不是一个代理类
**/
//动态代理
//描述:代理类在程序运行期间是由JVM通过反射机制动态生成的字节码文件。
// 代理对象和真实对象的关系是在程序运行时才确定的。
// (代理类以及对象不需要我们创建)
//两种方式: jdk动态代理cglib动态代理
@Service("transInvocationHandler")
public class TransInvocationHandler implements InvocationHandler {
//引入真实的业务对象
//    @Autowired
//    @Qualifier("UserService")
//@Autowired装配Spring上下文中存在不止一个类型的bean时使用

    @Resource(name = "UserService")
    private Object target;

    public Object getTarget(){
        return target;
    }
    //引入跟事务相关的事务管理器
    @Resource(name = "txManager")
    private DataSourceTransactionManager manager;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = manager.getTransaction(definition);
        String message = "执行成功，没有事务回滚";
        Object value=null;
        try{
            value=method.invoke(target,args);//实行主要执行方法
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
