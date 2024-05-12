package com.ziker0k.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task2 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(dateTimeFormatter.format(now));
    }
}
