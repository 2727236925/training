package com.example.training01.Spring;

import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Animal> {

    @Override
    public Animal getObject() throws Exception {
        return new Animal("hellocat", 12);
    }


    public Class<?> getObjectType(){
        return Animal.class;
    }
}
//懒加载: spring延迟创建bean的时间，通常在初始化的时候就常见，懒加载在容器初始化的时候，暂时不创建该Bean（对象)
//    单个bean懒加载:
//    <bean id="p2" class="com.wolfcode.spring4.Person2" lazy-init="true"></bean>
//    全局bean懒加载:default-lazy-init="true"
//    懒加载节省资源 但第一次耗时长
