package com.ty.demo.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i=0;i<10;i++){
            sum+=i;
        }
        return sum;
    }
}
class  CallableTest2{
    public static void main(String[] args) {
        CallableTest callableTest=new CallableTest();
        CallableTest callableTest2=new CallableTest();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(callableTest);
        FutureTask<Integer> futureTask2=new FutureTask<Integer>(callableTest2);
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        try {
            System.out.println("futureTask-----:"+futureTask.get());
            System.out.println("futureTask2-----:"+futureTask2.get());

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
