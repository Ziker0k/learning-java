package com.ziker0k.lesson27.homework.dto;

import java.time.LocalTime;

public record LogFileRow(LocalTime time, String activityName) {
}
