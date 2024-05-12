package com.ziker0k.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task3 {
    public static void main(String[] args) {
        String date = "26-03-1968T09:24";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime result = LocalDateTime.parse(date, dateTimeFormatter);
        System.out.println(result);
    }
}
