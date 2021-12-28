package com.ty.demo.test.future;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("begin");
        Host host=new Host();
        Data data1=host.request(10,'A');
        Data data2=host.request(20,'B');
        Data data3=host.request(30,'C');
        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("main otherJob END");
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main END");
    }
}

class  Test2{
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(4);     // 创建一个ScheduledExecutorService实例

        final ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(new BeepTask(), 10, 10,
                TimeUnit.SECONDS);                              // 每隔10s蜂鸣一次
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public synchronized void run() {
                System.out.println("123123");
            }
        },0,1000,TimeUnit.MILLISECONDS);

        scheduler.schedule( () ->  {
            scheduledFuture.cancel(true);

        }, 1, TimeUnit.HOURS);   // 1小时后, 取消蜂鸣任务

    }

    private static class BeepTask implements Runnable {
        @Override
        public  void run() {
            System.out.println("123!");
        }
    }
}
