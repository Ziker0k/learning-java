package com.ziker0k.lesson27.homework.report;

import com.ziker0k.lesson27.homework.dto.Activity;
import com.ziker0k.lesson27.homework.dto.LogFileDay;
import com.ziker0k.lesson27.homework.util.ActivityUtils;

import java.time.temporal.ChronoUnit;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatisticReportGenerator implements ReportGenerator {
    public static final String DETAILER_PART_PREFIX = "Лекции: ";
    public static final String REPORT_PART_ROW_FORMAT = "%s: %d минут %d%%";

    @Override
    public String generate(List<LogFileDay> logFileDays) {
        return logFileDays.stream()
                .flatMap(logFileDay -> Stream.of(generateCommonPart(logFileDay), generateDetailPart(logFileDay)))
                .collect(Collectors.joining(System.lineSeparator() + System.lineSeparator()));
    }

    private String generateCommonPart(LogFileDay logFileDay) {
        Map<Activity, Long> activitiesTime = new EnumMap<>(Activity.class);
        ActivityUtils.consumeActivityDuration(logFileDay, (currentLogFileRow, nextLogFileRow) -> {
            long minutesDuration = ChronoUnit.MINUTES.between(currentLogFileRow.time(), nextLogFileRow.time());
            activitiesTime.merge(Activity.find(currentLogFileRow.activityName()), minutesDuration, Long::sum);
        });

        long allTime = activitiesTime.values().stream()
                .mapToLong(Long::valueOf)
                .sum();

        return activitiesTime.entrySet().stream()
                .map(activityLongEntry -> buildReportPart(activityLongEntry.getKey().getName(),
                        activityLongEntry.getValue(), allTime))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String generateDetailPart(LogFileDay logFileDay) {
        Map<String, Long> lectures = new HashMap<>();
        AtomicLong allTime = new AtomicLong();
        ActivityUtils.consumeActivityDuration(logFileDay, (currentLogFileRow, nextLogFileRow) -> {
            long minutesDuration = ChronoUnit.MINUTES.between(currentLogFileRow.time(), nextLogFileRow.time());
            allTime.addAndGet(minutesDuration);
            if (Activity.find(currentLogFileRow.activityName()) == Activity.LECTURES)
                lectures.put(currentLogFileRow.activityName(), minutesDuration);
        });

        return Stream.concat(
                        Stream.of(DETAILER_PART_PREFIX),
                        lectures.entrySet().stream().map(entry -> buildReportPart(entry.getKey(), entry.getValue(), allTime.get()))
                )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String buildReportPart(String activityName, Long activityTime, long allTime) {
        long percent = (long) ((double) activityTime / allTime * 100);
        return String.format(REPORT_PART_ROW_FORMAT, activityName, activityTime, percent);
    }
}
