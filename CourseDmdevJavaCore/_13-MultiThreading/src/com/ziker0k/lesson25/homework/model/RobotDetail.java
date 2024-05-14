package com.ziker0k.lesson25.homework.model;

import java.util.Arrays;
import java.util.List;

/**
 * Голова, Тело, Левая рука, Правая рука, Левая нога, Правая нога, CPU, RAM, HDD
 */
public enum RobotDetail {
    HEAD,
    BODY,
    LEFT_ARM,
    RIGHT_ARM,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    public static final List<RobotDetail> CASHED_VALUES = Arrays.asList(values());
}