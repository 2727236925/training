package com.example.training01.Factory;

public class SimpleFactory {
    public Pay createPay(String payType){
        if("alipay".equals(payType)){
            return new Alipay();
        }
        else if("wechatpay".equals(payType)){
            return new wechatPay();
        }
        else {
            System.out.println("不清楚的支付方式");
        }
        return null;
    }
}
