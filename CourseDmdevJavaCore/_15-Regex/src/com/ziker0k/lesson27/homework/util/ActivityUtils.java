package com.ziker0k.lesson27.homework.util;

import com.ziker0k.lesson27.homework.dto.LogFileDay;
import com.ziker0k.lesson27.homework.dto.LogFileRow;

import java.util.List;
import java.util.function.BiConsumer;

public final class ActivityUtils {
    private ActivityUtils() {
    }

    public static void consumeActivityDuration(LogFileDay logFileDay, BiConsumer<LogFileRow, LogFileRow> consumer) {
        List<LogFileRow> rows = logFileDay.getRows();
        for (int i = 0; i < rows.size() - 1; i++) {
            LogFileRow currentLogFileRow = rows.get(i);
            LogFileRow nextLogFileRow = rows.get(i + 1);
            consumer.accept(currentLogFileRow, nextLogFileRow);
        }
    }
}
