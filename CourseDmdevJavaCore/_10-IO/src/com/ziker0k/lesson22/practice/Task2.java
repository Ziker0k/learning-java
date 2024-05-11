package com.ziker0k.lesson22.practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        Path text = Path.of("resources", "Text.txt");
        try (Scanner scanner = new Scanner(text)) {
            String prev = null;
            if (scanner.hasNext())
                prev = scanner.next();
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (isEqualLastSymbolAndFirstSymbol(prev, current))
                    System.out.println(String.join(" - ", prev, current));
                prev = current;
            }
        }
    }

    private static boolean isEqualLastSymbolAndFirstSymbol(String prev, String current) {
        return prev.toLowerCase().charAt(prev.length() - 1) == current.toLowerCase().charAt(0);
    }
}
