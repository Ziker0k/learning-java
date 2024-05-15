package com.ziker0k.lesson26.practice;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        int[] values = new int[100_000_000];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(300 + 1);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        trackTime(() -> {
            try {
                return findMaxParallel(values, executorService);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        trackTime(() -> findMax(values));

        executorService.shutdown();
    }

    public static int trackTime(Supplier<Integer> task) {
        long startTime = System.currentTimeMillis();
        int result = task.get();
        System.out.println(result + ": " + (System.currentTimeMillis() - startTime));
        return result;
    }

    public static int findMax(int[] values) {
        return IntStream.of(values)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public static int findMaxParallel(int[] values, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(values)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }
}
