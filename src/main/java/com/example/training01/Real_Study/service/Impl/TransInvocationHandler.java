package com.example.training01.Real_Study.service.Impl;

import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
*事务管理增强的一个模板
*事务管理增强的工具类
* ————不是一个代理类
**/
@Service("translnvationHandler")
public class TransInvotionHandler implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
