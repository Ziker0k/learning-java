package com.ziker0k.lesson25.vol;

public class VolatileDemo {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!flag)
                System.out.println("still false");
        });
        thread1.start();

        Thread.sleep(100L);

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");
        });
        thread2.start();
    }
}
