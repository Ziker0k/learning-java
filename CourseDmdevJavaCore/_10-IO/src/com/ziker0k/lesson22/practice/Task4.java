package com.ziker0k.lesson22.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task4 {
    public static void main(String[] args) throws IOException {
        Path inputPath = Path.of("src", "com", "ziker0k", "lesson22", "practice", "Task3.java");
        String stringValue = Files.readString(inputPath);
        String result = stringValue.replace("public", "private");

        Path outputPath = Path.of("resources", "NewTask3.java");
        Files.writeString(outputPath, result);
    }
}
