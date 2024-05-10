package com.ziker0k.lesson21.practice;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> strings = List.of(
                "Hashmaphghhggh",
                "HFDFDFPDFPDF",
                "Brute",
                "Force",
                "Force",
                "Duplex",
                "ARMAGEDDON",
                "Hashmaphghhggh",
                "Brute");

//        int size = strings.stream()
//                .filter(s -> s.length() > 8)
//                .collect(Collectors.toSet())
//                .size();

        long size = strings.stream()
                .filter(s -> s.length() > 8)
                .distinct()
                .count();

        System.out.println(size);
    }
}
