package com.ziker0k.lesson26.practice;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds < 0)
                break;
            executorService.submit(() -> {
                Integer counter = threadLocal.get();
                threadLocal.set(counter == null ? 1 : ++counter);
                System.out.printf("Поток '%s', задач '%d'%n", Thread.currentThread().getName(), threadLocal.get());

                Thread.sleep(seconds * 1000L);
                System.out.printf("Поток '%s' спал '%d' секунд%n", Thread.currentThread().getName(), seconds);
                return seconds;
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10L, TimeUnit.MINUTES);

    }
}
