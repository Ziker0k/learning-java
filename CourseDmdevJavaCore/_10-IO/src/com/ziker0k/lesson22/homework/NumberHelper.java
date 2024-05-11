package com.ziker0k.lesson22.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class NumberHelper {
    private NumberHelper() {
    }

    public static List<String> generateListOfStringsWithRandomNumbers(int length) {
        Random random = new Random();
        List<String> stringsWithNumbers = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            stringsWithNumbers.add(String.valueOf(random.nextInt(0, 1000)));
        }
        return stringsWithNumbers;
    }

    public static List<String> getSortedStringsOfNumbersInFile(Path numbersPath) throws IOException {
        try (Stream<String> stream = Files.lines(numbersPath)) {
            return stream.map(Integer::parseInt)
                    .flatMapToInt(IntStream::of)
                    .sorted()
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
        }
    }
}
