package com.example.training01.Factory;


public class MyTest {
        @Test
        public void test1() {
            MyService dervice = new MyService();
            MyService.usePay("wechatPay");
        }

        @Test
        public void test2(){

        }
}
