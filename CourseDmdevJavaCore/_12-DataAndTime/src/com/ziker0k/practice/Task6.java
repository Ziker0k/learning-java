package com.ziker0k.practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task6 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate prevDate = LocalDate.parse("07.07.2018", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        LocalDateTime nowLocalDateTime = LocalDateTime.of(now, LocalTime.MIDNIGHT);
        LocalDateTime prevLocalDateTime = LocalDateTime.of(prevDate, LocalTime.MIDNIGHT);

        Duration between = Duration.between(prevLocalDateTime, nowLocalDateTime);
        System.out.println(between.toSeconds());

    }
}
