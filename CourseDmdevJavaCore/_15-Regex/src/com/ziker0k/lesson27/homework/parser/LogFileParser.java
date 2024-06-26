package com.ziker0k.lesson27.homework.parser;

import com.ziker0k.lesson27.homework.dto.Activity;
import com.ziker0k.lesson27.homework.dto.LogFileDay;
import com.ziker0k.lesson27.homework.dto.LogFileRow;
import com.ziker0k.lesson27.homework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileParser {
    private static final String HOUR_GROUP = "hour";
    private static final String MINUTE_GROUP = "minute";
    private static final String ACTIVITY_GROUP = "activity";
    private static final String LOG_FILE_REGEXP = "^(?<hour>\\d{2}):(?<minute>\\d{2}) (?<activity>.+)$";
    private static final Pattern PATTERN = Pattern.compile(LOG_FILE_REGEXP);

    public List<LogFileDay> parse(Path path) throws IOException {
        List<LogFileRow> rows = buildLogFileRows(path);
        return buildLogFileDays(rows);
    }

    private List<LogFileRow> buildLogFileRows(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.filter(Predicate.not(StringUtils.EMPTY::equals))
                    .map(this::buildLogFileRow)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
    }

    private Optional<LogFileRow> buildLogFileRow(String line) {
        return Optional.of(line)
                .map(lin -> PATTERN.matcher(lin))
                .filter(Matcher::find)
                .map(matcher -> {
                    var hour = Integer.parseInt(matcher.group(HOUR_GROUP));
                    var minute = Integer.parseInt(matcher.group(MINUTE_GROUP));
                    var activity = matcher.group(ACTIVITY_GROUP);
                    return new LogFileRow(LocalTime.of(hour, minute), activity);
                });
    }

    private List<LogFileDay> buildLogFileDays(List<LogFileRow> logFileRows) {
        List<LogFileDay> result = new ArrayList<>();
        LogFileDay logFileDay = new LogFileDay();

        for (LogFileRow row : logFileRows) {
            logFileDay.add(row);
            if (Activity.END.getName().equals(row.activityName())) {
                result.add(logFileDay);
                logFileDay = new LogFileDay();
            }
        }
        return result;
    }
}