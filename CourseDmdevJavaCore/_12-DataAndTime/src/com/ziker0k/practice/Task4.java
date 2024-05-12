package com.ziker0k.practice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Task4 {
    public static void main(String[] args) {
        String date = "26-03-1968T09:24";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime result = LocalDateTime.parse(date, dateTimeFormatter);

        Instant instant = result.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(result));
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());
    }
}
