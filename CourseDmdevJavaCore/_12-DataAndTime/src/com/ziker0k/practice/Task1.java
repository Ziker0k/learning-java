package com.ziker0k.practice;

import java.time.LocalDateTime;

public class Task1 {
    public static void main(String[] args) {
        LocalDateTime localdateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime resultLocalDateTime = localdateTime.plusMonths(3);
        System.out.println(resultLocalDateTime.toLocalDate() + " - " + resultLocalDateTime.toLocalTime());
    }
}
