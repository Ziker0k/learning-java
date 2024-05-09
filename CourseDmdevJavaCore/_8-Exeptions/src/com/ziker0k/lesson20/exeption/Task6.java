package com.ziker0k.lesson20.exeption;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class Task6 {
    private static final Map<Integer, Throwable> EXCEPTIONS = Map.of(
            0, new RuntimeException("runtime"),
            1, new IOException("input output exception"),
            2, new FileNotFoundException("file not found")
    );

    public static void main(String[] args) {
        Random random = new Random();
        try {
            unsafe(random.nextInt(3));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void unsafe(int randomValue) throws Throwable {
        throw EXCEPTIONS.getOrDefault(randomValue, new Ziker0kException("not found"));
    }
}
