package com.ziker0k.lesson26.barrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length, () -> System.out.println("Пуск"));
        ExecutorService executorService = Executors.newCachedThreadPool();
        Arrays.stream(RocketDetail.values())
                .map(rocketDetail -> new RocketDetailRunnable(rocketDetail, cyclicBarrier))
                .forEach(executorService::submit);

        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.HOURS);
    }
}
