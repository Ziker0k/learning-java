package com.ziker0k.lesson27.homework.dto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Activity {
    LECTURES("Лекции"),
    EXERCISES("Упражнения"),
    BREAK("Перерыв"),
    SOLUTIONS("Решения"),
    LUNCH_BREAK("Обеденный перерыв"),
    END("Конец");

    private static final Map<String, Activity> ACTIVITY_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(Activity::getName, activity -> activity));

    private final String name;

    Activity(String name) {
        this.name = name;
    }

    public static Activity find(String activityName) {
        return ACTIVITY_MAP.getOrDefault(activityName, LECTURES);
    }

    public String getName() {
        return name;
    }
}
