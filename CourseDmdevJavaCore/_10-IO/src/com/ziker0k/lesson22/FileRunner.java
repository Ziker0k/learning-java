package com.ziker0k.lesson22;

import java.io.File;
import java.io.IOException;

public class FileRunner {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/Text.txt");
        System.out.println(file.createNewFile());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        File dir = new File("resources/test/directory");
        dir.mkdirs();
    }

}
