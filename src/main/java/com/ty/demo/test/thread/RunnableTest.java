package com.ty.demo.test.thread;

public class RunnableTest implements Runnable {
    private  String name;

    public  RunnableTest( String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(name + "运行，i = " + i) ;
        }
    }
}
class test{
    public static void main(String[] args) {
        RunnableTest test=new RunnableTest("线程1");
        RunnableTest test2=new RunnableTest("线程2");
        Thread t1=new Thread(test);
        Thread t2=new Thread(test2);
        t1.start();
        t2.start();
    }
}
