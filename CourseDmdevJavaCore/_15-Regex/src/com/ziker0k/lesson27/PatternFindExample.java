package com.ziker0k.lesson27;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFindExample {
    public static void main(String[] args) {
        String phoneNumbers = """
                +375(33) 898-12-13 kjljljl,lkjk +375(21) 777-44-22 fgfgf +375(10) 444-11-11
                """;
        String regex = "(?:\\+375)? ?\\((?<code>\\d{2})\\) ?\\d{3}-\\d{2}-\\1";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phoneNumbers);
        while (matcher.find()) {
            System.out.println(matcher.group("code"));
            System.out.println(matcher.group(1));
        }
    }
}
