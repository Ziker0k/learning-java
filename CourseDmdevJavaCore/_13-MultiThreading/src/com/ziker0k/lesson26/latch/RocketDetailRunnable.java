package com.ziker0k.lesson26.latch;

import java.util.concurrent.CountDownLatch;

public class RocketDetailRunnable implements Runnable {
    private final RocketDetail rocketDetail;
    private final CountDownLatch countDownLatch;

    public RocketDetailRunnable(RocketDetail rocketDetail, CountDownLatch countDownLatch) {
        this.rocketDetail = rocketDetail;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь: " + rocketDetail);
        try {
            Thread.sleep(500L);
            System.out.println("Деталь готова: " + rocketDetail);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
