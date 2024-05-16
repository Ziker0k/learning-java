package com.ziker0k.lesson27.practice;

public class Task3 {
    public static void main(String[] args) {
        String regex = "(<p .+?>)(.+?</p>)";

        String input = """
                <p>dsdsdsdsds </p> <b> sdsdsd </b> <p id="p1"> fgfgfgfg</p> <p>
                """;

        String all = input.replaceAll(regex, "<p>$2");
        System.out.println(all);
    }
}
