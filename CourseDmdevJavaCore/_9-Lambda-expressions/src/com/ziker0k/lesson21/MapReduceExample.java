package com.ziker0k.lesson21;

import java.util.Optional;
import java.util.stream.Stream;

public class MapReduceExample {

    /**
     *
     *
     *
     */
    public static void main(String[] args) {
        Optional<Student> maybeStudent = Stream.of(
                        new Student(18, "Ivan"),
                        new Student(23, "Petr"),
                        new Student(32, "Bogdan"),
                        new Student(45, "Bruce"),
                        new Student(22, "Lee"),
                        new Student(50, "Ravshan"),
                        new Student(61, "Leonid"),
                        new Student(43, "Pavel"),
                        new Student(20, "Mihail"),
                        new Student(32, "Grace"),
                        new Student(23, "Bob"),
                        new Student(19, "Martin")
                )
                .sequential()
//                .map(Student::getAge)
                .filter(student -> student.getAge() < 18)
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

        maybeStudent.ifPresent(System.out::println);
    }
}

