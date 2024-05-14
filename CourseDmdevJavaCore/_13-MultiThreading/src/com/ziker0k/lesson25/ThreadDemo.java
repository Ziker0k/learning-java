package com.ziker0k.lesson25;

import java.util.List;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        List<Thread> threads =
                IntStream.iterate(0, it -> it + 1)
                        .limit(100)
                        .mapToObj(integer -> new Thread(new CounterThread(counter)))
                        .toList();

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(counter.getCount());
    }
}
