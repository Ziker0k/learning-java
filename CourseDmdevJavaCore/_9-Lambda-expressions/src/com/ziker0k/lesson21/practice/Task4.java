package com.ziker0k.lesson21.practice;

import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 5, 7, 9);
        String result = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
