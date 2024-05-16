package com.ziker0k.lesson27.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String regex = "0[xX][0-9a-fA-F]+";
        String input = """
                0xff dfdfdfdf dfdfdf 0x12 dfdfdfdf 0XAB asdf"
                """;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
