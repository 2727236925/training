package com.example.training01.AopStudy.util;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("computeTime")
@Aspect
@Order(0)
public class ComputeTime {

    private Long startTime;
    private Long endTime;

    @Pointcut("execution(* com.example.training01.AopStudy.service.Impl.UserServiceImpl.UserUpdate(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void getStartTime(){
        startTime= System.currentTimeMillis();
        System.out.println("获取到开始时间戳");
    }


    @AfterThrowing("pointCut()")
    public void getEndTime(){
        endTime = System.currentTimeMillis();//做差打印出耗时
        System.out.println("获取到结束时间戳");
        System.out.println((endTime-startTime)+"ms") ;
    }
    @AfterReturning("pointCut()")
    public void getEndTimeR(){
        endTime = System.currentTimeMillis();//做差打印出耗时
        System.out.println("获取到结束时间戳");
        System.out.println((endTime-startTime)+"ms") ;
    }
}
