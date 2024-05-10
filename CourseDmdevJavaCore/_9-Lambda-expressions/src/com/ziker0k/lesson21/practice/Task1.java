package com.ziker0k.lesson21.practice;

import java.util.List;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 5, 10, 14, 15, 16, 20, 40, 55, 61, 64, 66, 70, 80);
        OptionalDouble average1 = integerList.stream()
                .filter(integer -> integer % 2 != 0)
                .filter(integer -> integer % 5 == 0)
                .mapToInt(Integer::intValue)
                .average();
        average1.ifPresent(System.out::println);
    }
}
