package com.ty.demo.test.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    void test1() throws ExecutionException, InterruptedException {
        /**
         * supply开头：这种方法，可以返回异步线程执行之后的结果
         * run开头：这种不会返回结果，就只是执行线程任务
         */
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() ->{
            int a = 0;
            for (int i=0;i<=5;i++){
                try {
                    Thread.sleep(500);
                    a+=i;
                    System.out.println(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return  a;
        });
        /**
         *  getNow() 则有所区别，参数valueIfAbsent的意思是当计算结果不存在或者Now时刻没有完成任务，给定一个确定的值。
         *  join() 与get() 区别在于join() 返回计算的结果或者抛出一个unchecked异常(CompletionException)，而get() 返回一个具体的异常.
         */
        System.out.println("future:"+future.get());
        System.out.println("future2:"+future.getNow(100));
        System.out.println("join()"+future.join());
    }
    void test2() throws ExecutionException, InterruptedException {

        CompletableFuture<List> future = CompletableFuture.supplyAsync(() -> {
            List<Integer>list=new ArrayList<>();
            for (int i=0;i<=5;i++){
                 list.add(i);
            }
            return list;
        });
        future.whenComplete((result,error)->{
            System.out.println("whenCompete------------------");
            result.forEach(l-> System.out.println(l));
            error.printStackTrace();
        });

        CompletableFuture<Object> handle = future.handle((list,error) -> {
            System.out.println("handle------------------");
            list.forEach(l -> System.out.println(l));
            error.printStackTrace();
            return list.get(0);
        });
        System.out.println(handle.get());
    }

    void test3() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                return  null;
        });
        CompletableFuture<String> thenApply = future.thenApply(result -> {
            int i = result;
            return i;
        }).thenApply(result->{
            String words = "现在是" + result + "点钟";
            return words;
        }).exceptionally(e ->{
            e.printStackTrace();
            return "异常" ;
        });
       // System.out.println(thenApply.get());
        thenApply.thenAccept(r -> System.out.println(r));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureTest test=new CompletableFutureTest();
        //test.test1();
       // test.test2();
        test.test3();
    }
}
