package com.ziker0k.lesson19.practice;

import java.util.HashSet;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        Map<String, String> hashMap = Map.of(
                "Marty", "Stepp",
                "Bob", "One",
                "Keks", "Two",
                "Grandy", "Three",
                "Fandy", "Four",
                "Bruce", "Five"
//                ,"Kandy", "Five"
        );
        System.out.println(isUnique(hashMap));
    }

    private static boolean isUnique(Map<String, String> map) {
        return map.size() == new HashSet<>(map.values()).size();
    }
}
