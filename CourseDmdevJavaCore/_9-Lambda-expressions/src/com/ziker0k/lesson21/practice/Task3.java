package com.ziker0k.lesson21.practice;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "Ivan-1", 10,
                "Ivan-2", 500,
                "Ivan-3", 500,
                "Ivan-4", 500,
                "Ivan-5", 500,
                "Ivan-6", 500,
                "Ivan-10", 500,
                "Ivan-11", 500,
                "Ivan-12", 500,
                "Ivan-13", 500
        );
        Optional<Integer> result = map.entrySet().stream()
                .filter(entry -> entry.getKey().length() < 7)
                .map(Map.Entry::getValue)
                .reduce(Integer::sum);

        result.ifPresent(System.out::println);
    }

}
