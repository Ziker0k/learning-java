package com.ziker0k.lesson19.map;

import com.ziker0k.lesson19.person.Person;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Person ivan = new Person(28, "Ivan", "Ivanov");
        Person petr = new Person(10, "Petr", "Petrov");
        Person sveta = new Person(45, "Sveta", "Petrova");

        Map<Integer, Person> map = new LinkedHashMap<>();
        map.put(ivan.getId(), ivan);
        map.put(petr.getId(), petr);
        map.put(sveta.getId(), sveta);

        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
