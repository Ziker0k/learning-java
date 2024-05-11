package com.ziker0k.lesson22;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputStreamRunner {
    public static void main(String[] args) {
        File file = Path.of("resources", "Text.txt").toFile();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
