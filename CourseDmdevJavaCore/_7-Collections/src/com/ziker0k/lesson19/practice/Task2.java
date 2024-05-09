package com.ziker0k.lesson19.practice;

import java.util.HashSet;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 1, 2, 5, 6, 7, 8, 5, 1, 1, 4, 2);
        System.out.println(countUnique(list));
    }

    private static int countUnique(List<Integer> list) {
        return new HashSet<>(list).size();
    }
}
