package com.ziker0k.lesson26.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000L);
            System.out.println("It's callable");
            return 1;
        });

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);
        System.out.println("main end");

    }
}
