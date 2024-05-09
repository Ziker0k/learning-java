package com.ziker0k.lesson19.practice;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 6, 8, 9, 11, 15, 18);
        List<Integer> result = removeEven(list);
        System.out.println(result);

    }

    private static List<Integer> removeEven(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 1)
                newList.add(integer);
        }
        return newList;
    }
}
