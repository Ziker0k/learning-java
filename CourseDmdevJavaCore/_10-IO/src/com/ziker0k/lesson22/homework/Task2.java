package com.ziker0k.lesson22.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class Task2 {
    /**
     * Создать программно и заполнить файл случайными целыми числами.
     * Отсортировать содержимое файла по возрастанию.
     */
    public static void main(String[] args) throws IOException {
//        Path numbersPath = Path.of("resources", "Numbers.txt");
//        Path resultPath = Path.of("resources", "SortedNumbers.txt");
//        List<String> listOfStringsWithRandomNumbers = generateListOfStringsWithRandomNumbers(100);
//        Files.write(numbersPath, listOfStringsWithRandomNumbers, CREATE, TRUNCATE_EXISTING);
//
//        List<String> sortedListOfStringsWithRandomNumbers = getSortedStringsOfNumbersInFile(numbersPath);
//        Files.write(resultPath, sortedListOfStringsWithRandomNumbers, CREATE, TRUNCATE_EXISTING);

        Path resultPath = Path.of("resources", "task2-result.txt");
        Files.write(resultPath, RandomUtil.generateDigits(100), CREATE, TRUNCATE_EXISTING);
        Files.write(resultPath, DigitHelper.readSorted(resultPath), TRUNCATE_EXISTING);
    }
}
