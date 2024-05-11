package com.ziker0k.lesson22;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("resources", "Text.txt").toFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result = reader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(result);
        }
    }
}
