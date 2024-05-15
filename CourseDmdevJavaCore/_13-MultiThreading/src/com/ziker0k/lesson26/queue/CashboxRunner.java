package com.ziker0k.lesson26.queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class CashboxRunner {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<CashBox> cashBoxes = new ArrayBlockingQueue<>(2, true, List.of(
                new CashBox(),
                new CashBox()
        ));

        List<Thread> threads = Stream.of(
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes),
                        new BuyerThread(cashBoxes)
                )
                .map(Thread::new)
                .peek(Thread::start)
                .toList();

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
