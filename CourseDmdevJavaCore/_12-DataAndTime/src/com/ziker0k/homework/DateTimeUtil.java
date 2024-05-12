package com.ziker0k.homework;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class DateTimeUtil {
    private DateTimeUtil() {
    }

    public static Duration getDurationToNewYear(LocalDateTime localDateTime) {
        LocalDateTime of = LocalDateTime.of(
                LocalDate.of(localDateTime.getYear() + 1, 1, 1),
                LocalTime.of(localDateTime.getHour(), localDateTime.getMinute()));
        return Duration.between(localDateTime, of);
    }
}
