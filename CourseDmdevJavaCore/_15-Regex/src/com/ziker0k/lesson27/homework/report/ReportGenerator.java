package com.ziker0k.lesson27.homework.report;

import com.ziker0k.lesson27.homework.dto.LogFileDay;

import java.util.List;

public interface ReportGenerator {
    public String generate(List<LogFileDay> list);
}
