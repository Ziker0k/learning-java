package com.ziker0k.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task5 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate secondDate = LocalDate.parse("07.07.2018", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        long days = ChronoUnit.DAYS.between(secondDate, today);
        System.out.println(days);
    }
}
