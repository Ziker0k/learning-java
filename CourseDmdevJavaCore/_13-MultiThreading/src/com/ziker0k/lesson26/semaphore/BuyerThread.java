package com.ziker0k.lesson26.semaphore;

import java.util.concurrent.Semaphore;

public class BuyerThread implements Runnable {
    private final Semaphore cashBoxes;

    public BuyerThread(Semaphore cashBoxes) {
        this.cashBoxes = cashBoxes;
    }

    @Override
    public void run() {
        try {
            cashBoxes.acquire();
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе ");
            Thread.sleep(5L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу ");
            cashBoxes.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
