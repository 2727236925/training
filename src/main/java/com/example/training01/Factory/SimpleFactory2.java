package com.example.training01.Factory;

public class SimpleFactory2 extends SimpleFactory{

    public Pay createPay (String payType){
        return new HUAWEIPay() ;
    }

}
