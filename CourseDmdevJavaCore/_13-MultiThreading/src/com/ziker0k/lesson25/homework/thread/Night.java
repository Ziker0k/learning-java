package com.ziker0k.lesson25.homework.thread;

import com.ziker0k.lesson25.homework.util.NightConst;

public class Night extends Thread {
    private final Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < NightConst.AMOUNT_OF_NIGHT; i++) {
            synchronized (lock) {
                try {
                    System.out.printf("""
                            ----------------
                            Night %s started
                                                        
                            """, i + 1
                    );
                    lock.notifyAll();
                    lock.wait(NightConst.NIGHT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            System.out.println("""
                                        
                    -----------------
                    All nights ended.
                    -----------------
                    """);
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}
