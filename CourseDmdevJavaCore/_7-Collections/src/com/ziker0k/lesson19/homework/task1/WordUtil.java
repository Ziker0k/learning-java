package com.ziker0k.lesson19.homework.task1;

import java.util.HashMap;
import java.util.Map;

public final class WordUtil {
    private WordUtil() {
    }

    public static Map<String, Integer> countWordFrequency(String text) {
        String textWithoutSmth = text.trim().replaceAll("\\p{Punct}", "");
        Map<String, Integer> map = new HashMap<>();
        for (String s : textWithoutSmth.split(" ")) {
            map.put(s.trim(), map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}
