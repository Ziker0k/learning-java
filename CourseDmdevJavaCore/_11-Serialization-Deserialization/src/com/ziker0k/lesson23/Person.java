package com.ziker0k.lesson23;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;

    private String firstname;

    public Person(int age, String firstname) {
        this.age = age;
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
