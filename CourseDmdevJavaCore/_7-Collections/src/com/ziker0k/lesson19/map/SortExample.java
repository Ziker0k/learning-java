package com.ziker0k.lesson19.map;

import com.ziker0k.lesson19.person.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("123", "456", "14", "789");
//        Collections.sort(strings);
//        System.out.println(strings);


        List<Person> personList = Arrays.asList(
                new Person(1, "Ivan", "Ivanov"),
                new Person(29, "Petr", "Petrov"),
                new Person(10, "Sveta", "Svetikova")
        );

        Collections.sort(personList);
        System.out.println(personList);

        personList.sort(new FirstNameComparator());
        System.out.println(personList);
    }

    public static class FirstNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }
}
