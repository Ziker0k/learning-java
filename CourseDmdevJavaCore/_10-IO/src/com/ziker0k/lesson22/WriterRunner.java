package com.ziker0k.lesson22;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WriterRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("resources", "writer.txt").toFile();
        try (BufferedWriter fileWriter = new BufferedWriter( new FileWriter(file, true))) {
            fileWriter.append("Hello, world!");
            fileWriter.newLine();
            fileWriter.append("Java");
        }

    }
}
