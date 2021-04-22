package com.ty.demo;

public class TreadTest extends Thread {
    private  String name;

    public  TreadTest(String name){
       this.name=name;
    }

    public static void main(String[] args) {
        TreadTest t1=new TreadTest("门店一");
        TreadTest t2 =new TreadTest("门店二");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        int i=10;
        while (i>0){
            i--;
            System.out.println(name+"卖出一张票还剩"+i+"张票");
        }
    }
}
