package com.example.training01.Factory;

public class MyService2 {

    private SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory=simpleFactory;
    }

    public void usepay(String payType){

        Pay pay=simpleFactory.createPay(payType);

        pay.bulid();

        pay.sign();

        pay.verfifySign();

        pay.createPay();
    }

}
