package com.ziker0k.practice;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Task7 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime);
    }
}
