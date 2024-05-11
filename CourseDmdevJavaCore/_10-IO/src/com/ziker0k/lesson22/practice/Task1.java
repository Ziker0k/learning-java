package com.ziker0k.lesson22.practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task1 {
    public static final String VOWELS = "уеыаоэяию";
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "Text.txt");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                char firstChar = word.charAt(0);
                if(VOWELS.indexOf(firstChar) != -1 || VOWELS.toUpperCase().indexOf(firstChar) != -1)
                    System.out.println(word);
            }
        }
    }
}
