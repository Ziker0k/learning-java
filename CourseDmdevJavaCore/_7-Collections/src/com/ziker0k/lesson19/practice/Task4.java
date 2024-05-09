package com.ziker0k.lesson19.practice;

import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

public class Task4 {
    public static void main(String[] args) {
        Map<Integer, Integer> polynomial1 = Map.of(
                0, 5,
                1, 5,
                3, 2,
                5, 4,
                6, 7
        );

        Map<Integer, Integer> polynomial2 = Map.of(
                0, 5,
                3, 5,
                5, 5,
                6, 3
        );
//        10x^6 + 9x^5 + 7x^3 + 5x + 10

        Map<Integer, Integer> sumPolynomial = sum(polynomial1, polynomial2);

        System.out.println(polynomialToString(sumPolynomial));

    }

    public static Map<Integer, Integer> sum(Map<Integer, Integer> polynomial1, Map<Integer, Integer> polynomial2) {
        Map<Integer, Integer> sumPolynomial = new TreeMap<>(polynomial1);
        for (Map.Entry<Integer, Integer> entry : polynomial2.entrySet()) {
//            Integer key = entry.getKey();
//            Integer value = entry.getValue();
//            sumPolynomial.put(key, value + sumPolynomial.getOrDefault(key, 0));

            sumPolynomial.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return sumPolynomial;
    }

    public static String polynomialToString(Map<Integer, Integer> polynomial) {
        TreeMap<Integer, Integer> integerTreeMap = new TreeMap<>(polynomial);
        StringJoiner stringJoiner = new StringJoiner(" + ");

        for (Map.Entry<Integer, Integer> entry : integerTreeMap.descendingMap().entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            switch (key) {
                case 0 -> stringJoiner.add(value.toString());
                case 1 -> stringJoiner.add(value + "x");
                default -> stringJoiner.add(value + "x^" + key);
            }
        }
        return stringJoiner.toString();
    }


}
