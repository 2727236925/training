package com.example.training01.Factory;

public class MyService {

    public static void usePay(String payType){
        Pay pay=null;
        if("alipay".equals(payType)){
            pay=new Alipay();
        }
        else if("wechatPay".equals(payType)){
            pay=new wechatPay();
        }
        pay.bulid();
        pay.sign();
        pay.verfifySign();
        pay.createPay();
    }
}
