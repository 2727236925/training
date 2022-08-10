package com.example.training01.Factory;

public abstract class Pay {

    public abstract void bulid();

    public void sign(){
        System.out.println("执行签名");
    }

    public void verfifySign(){
        System.out.println("校验签名");
    }

    public void createPay(){
        System.out.println("创建预支付账单");
    }

}

class Alipay extends Pay {
    public void bulid() {
        System.out.println("支付宝支付");
    }
}
class wechatPay extends Pay {
    public void bulid() {
        System.out.println("微信支付");
    }
}

