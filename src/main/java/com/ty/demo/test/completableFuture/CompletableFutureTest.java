package com.ty.demo.test.completableFuture;

import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 使用CompletableFuture场景
 * 执行比较耗时的操作时，尤其是那些依赖一个或多个远程服务的操作，使用异步任务可以改善程序的性能，加快程序的响应速度
 * 使用CompletableFuture类，它提供了异常管理的机制，让你有机会抛出、管理异步任务执行种发生的异常
 * 如果这些异步任务之间相互独立，或者他们之间的的某一些的结果是另一些的输入，你可以讲这些异步任务构造或合并成一个
 * 小贴士 ：测试多线程的小伙伴请勿使用JUit单元测试，因为JUnit在主线程完成之后就会关闭JVM，有兴趣的小伙伴请自行百度
 * @throws ExecutionException
 * @throws InterruptedException
 */
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

    void test3() {
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

    void test4() {
        ExecutorService executors= Executors.newFixedThreadPool(5);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> 123).thenApply(i -> i.toString());
        System.out.println(future.join());
        CompletableFuture<List<String>> completableFuture = CompletableFuture.supplyAsync(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add("型号" + i);
            }
            return list;
        }, executors).thenCompose(l -> {
            CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    list.add("颜色" + i);
                }
                List<String> stringList = Stream.of(l, list).flatMap(Collection::stream).collect(Collectors.toList());
                return stringList;
            }, executors);
            return  listCompletableFuture;
        });
        completableFuture.join().stream().forEach(l -> System.out.println(l));

    }
    void test5(){
        CompletableFuture<List<String>> painting = CompletableFuture.supplyAsync(() -> {
            // 第一个任务获取美术课需要带的东西，返回一个list
            List<String> stuff = new ArrayList<>();
            stuff.add("画笔");
            stuff.add("颜料");
            return stuff;
        });
        CompletableFuture<List<String>> handWork = CompletableFuture.supplyAsync(() -> {
            // 第二个任务获取劳技课需要带的东西，返回一个list
            List<String> stuff = new ArrayList<>();
            stuff.add("剪刀");
            stuff.add("折纸");
            return stuff;
        });
        CompletableFuture<List<String>> total = painting
                // 传入handWork列表，然后得到两个CompletableFuture的参数Stuff1和2
                .thenCombine(handWork, (stuff1, stuff2) -> {
                    // 合并成新的list
                    List<String> totalStuff = Stream.of(stuff1, stuff1)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
                    return totalStuff;
                });
        total.join().stream().forEach(l -> System.out.println(l));
    }
    void test6() throws ExecutionException, InterruptedException {
        List<CompletableFuture> list=new ArrayList<>();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100);
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "100");
        CompletableFuture<Double> future2 = CompletableFuture.supplyAsync(() -> 100D);
        list.add(future);
        list.add(future1);
        list.add(future2);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()]));
        CompletableFuture<List<Object>> future3 = voidCompletableFuture.thenApply(v -> list.stream(
                ).map(futures -> futures.join()).
                        collect(Collectors.toList())
        );
        System.out.println(future3.join());
    }
    void test7(){
        List<CompletableFuture> list=new ArrayList<>();
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            throw new NullPointerException();
        });
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  "100";
        });
        CompletableFuture<Double> future2 = CompletableFuture.supplyAsync(() -> 10D);
        list.add(completableFuture);
        list.add(future1);
        list.add(future2);
        CompletableFuture<Object> completableFuture1 = CompletableFuture.anyOf(list.toArray(new CompletableFuture[list.size()]));
        CompletableFuture<List<Object>> future3 = completableFuture1.thenApply(v -> list.stream(
                ).map(futures -> futures.join()).
                        collect(Collectors.toList())
        ).exceptionally(e ->{
            e.printStackTrace();
            return Collections.singletonList("异常数据");
        });
        System.out.println(future3.join());
    }
    void test8(){
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Integer>> futureList = IntStream.range(1, 10).mapToObj(i -> {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                if (i == 5) {
                    throw new NullPointerException();
                }
                try {
                    TimeUnit.SECONDS.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                return i;
            }, executorService).exceptionally(e -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("空指针异常");
                return 100;
            });
            return future;
        }).collect(Collectors.toList());
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        System.out.println("最终耗时" + (System.currentTimeMillis() - begin) + "毫秒");
        executorService.shutdown();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureTest test=new CompletableFutureTest();
        // test.test1();
        // test.test2();
        // test.test3();
        // test.test4();
        // test.test5();
        // test.test6();
        // test.test7();
        test.test8();
    }
}
