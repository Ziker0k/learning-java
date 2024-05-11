package com.ziker0k.lesson22.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 {
    public static void main(String[] args) throws IOException {
        Path text = Path.of("resources", "Text.txt");
        Files.readAllLines(text).stream()
                .map(Task3::fineMaxDigitsCount)
                .forEach(System.out::println);
    }

    private static Integer fineMaxDigitsCount(String line) {
        int result = 0;
        int counter = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i)))
                counter++;
            else {
                if(result < counter)
                    result = counter;
                counter = 0;
            }
        }
        return result;
    }
}
