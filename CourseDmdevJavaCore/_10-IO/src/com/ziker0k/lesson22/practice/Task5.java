package com.ziker0k.lesson22.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Task5 {
    public static void main(String[] args) {
        Path inputPath = Path.of("src", "com", "ziker0k", "lesson22", "practice", "Task4.java");
        Path outputPath = Path.of("resources", "Task5CopyTask4.java");

        try (Stream<String> lines = Files.lines(inputPath);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath, APPEND, CREATE)) {
            lines.map(StringBuilder::new)
                    .map(StringBuilder::reverse)
                    .forEach(line -> {
                        try {
                            bufferedWriter.write(line.toString());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
