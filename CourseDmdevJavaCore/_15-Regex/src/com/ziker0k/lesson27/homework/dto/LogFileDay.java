package com.ziker0k.lesson27.homework.dto;

import java.util.ArrayList;
import java.util.List;

public class LogFileDay {
    private final List<LogFileRow> rows = new ArrayList<>();

    public void add(LogFileRow row) {
        rows.add(row);
    }

    public List<LogFileRow> getRows() {
        return rows;
    }
}
