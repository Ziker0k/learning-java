package com.ziker0k.lesson22.homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class Task1 {
    /**
     * 1. Задан файл со стихотворением Александра Пушкина.
     * Определить частоту повторяемости всех букв в стихотворении, игнорируя регистр.
     * Вывести результат в файл в виде:
     * а - 15
     * б - 7
     * и т.д.
     */
    public static void main(String[] args) throws IOException {
        Path poemPath = Path.of("resources", "Text.txt");
        Map<Character, Integer> characterFrequency = CharacterHelper.calcFrequency(poemPath);

        Path resultPath = Path.of("resources", "task1-result.txt");
        Files.write(resultPath, CharacterHelper.toListRepresentation(characterFrequency), CREATE, TRUNCATE_EXISTING);
    }

}
