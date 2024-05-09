package com.ziker0k.lesson19.person;

public class PersonExample {

    public static void main(String[] args) {
        Person ivan = new Person(1, "Ivan2", "Ivanov");
        Person petr = new Person(1, "Ivan", "Ivanov3");
//        Person petr = new Person(2, "Petr", "Petrov");

        System.out.println(ivan.hashCode());
        System.out.println(petr.hashCode());
        System.out.println(ivan.equals(petr));
    }
}