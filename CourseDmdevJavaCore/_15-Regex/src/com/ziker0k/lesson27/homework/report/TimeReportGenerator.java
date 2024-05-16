package com.ziker0k.lesson27.homework.report;

import com.ziker0k.lesson27.homework.dto.LogFileDay;
import com.ziker0k.lesson27.homework.util.ActivityUtils;
import com.ziker0k.lesson27.homework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class TimeReportGenerator implements ReportGenerator {

    @Override
    public String generate(List<LogFileDay> logFileDays) {
        return logFileDays.stream()
                .map(this::convertDay)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    private String convertDay(LogFileDay logFileDay) {
        StringBuilder result = new StringBuilder();
        ActivityUtils.consumeActivityDuration(logFileDay, (currentLogFileRow, nextLogFileRow) -> {
            result.append(currentLogFileRow.time().toString())
                    .append(StringUtils.DASH)
                    .append(nextLogFileRow.time().toString())
                    .append(StringUtils.SPACE)
                    .append(currentLogFileRow.activityName())
                    .append(System.lineSeparator());
        });
        return result.toString();
    }
}
