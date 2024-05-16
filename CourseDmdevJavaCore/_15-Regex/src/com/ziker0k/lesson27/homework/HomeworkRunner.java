package com.ziker0k.lesson27.homework;

import com.ziker0k.lesson27.homework.parser.LogFileParser;
import com.ziker0k.lesson27.homework.report.StatisticReportGenerator;
import com.ziker0k.lesson27.homework.report.TimeReportGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class HomeworkRunner {
    public static void main(String[] args) throws IOException {
        var logFilePath = Path.of("resources", "homework.log");
        var logFileParser = new LogFileParser();
        var logFileDays = logFileParser.parse(logFilePath);

        var timeReportGenerator = new TimeReportGenerator();
        var timeReport = timeReportGenerator.generate(logFileDays);
        Files.writeString(Path.of("resources", "time-report.txt"), timeReport, CREATE, TRUNCATE_EXISTING);

        var statisticReportGenerator = new StatisticReportGenerator();
        var statisticReport = statisticReportGenerator.generate(logFileDays);
        Files.writeString(Path.of("resources", "statistic-report.txt"), statisticReport, CREATE, TRUNCATE_EXISTING);
    }
}
