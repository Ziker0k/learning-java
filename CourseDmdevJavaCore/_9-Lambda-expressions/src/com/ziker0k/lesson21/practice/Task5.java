package com.ziker0k.lesson21.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Task5 {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ivan", "Ivanov", 21),
                new Person("Petr", "Petrov", 35),
                new Person("Igor", "Igorevich", 21),
                new Person("Mihail", "Mihailovich", 11),
                new Person("Bro", "Bragin", 24),
                new Person("Torin", "Duboshitdfdfddfdf", 105)
        );

        people.stream()
                .filter(person -> person.getFullName().length() < 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFullName)
                .ifPresent(System.out::println);

        Map<Integer, List<String>> map = people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getFullName, toList())));
        System.out.println(map);
    }
}
