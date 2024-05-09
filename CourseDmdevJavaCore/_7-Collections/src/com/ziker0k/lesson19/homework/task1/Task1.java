package com.ziker0k.lesson19.homework.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * 1. Задан текст на английском языке. Выделить все различные слова.
 * Для каждого слова подсчитать частоту его встречаемости.
 * Слова, отличающиеся регистром букв, считать различными.
 */
public class Task1 {
    public static void main(String[] args) {
        try {
            String text = readFromFile("src/com/ziker0k/lesson19/homework/Text.txt");
            System.out.println(WordUtil.countWordFrequency(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String path) throws IOException {
        try (BufferedReader br = java.nio.file.Files.newBufferedReader(Paths.get(path))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
            return stringBuilder.toString();
        }
    }
}
