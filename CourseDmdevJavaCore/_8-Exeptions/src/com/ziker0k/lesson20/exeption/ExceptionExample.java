package com.ziker0k.lesson20.exeption;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeoutException;

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            unsafe(-10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unsafe(int value) throws FileNotFoundException, TimeoutException {
        if (value > 0) {
            throw new FileNotFoundException();
        }
    }
}
