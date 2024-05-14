package com.ziker0k.lesson25;

public class Counter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    synchronized public void increment() {
        count++;
    }

    public void decrement() {
        synchronized (this) {
            count--;
        }
    }
}
