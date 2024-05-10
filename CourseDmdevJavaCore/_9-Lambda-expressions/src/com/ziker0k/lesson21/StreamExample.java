package com.ziker0k.lesson21;

import java.util.Comparator;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> stringList = List.of("11", "22", "33", "44", "55");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
    }
}
