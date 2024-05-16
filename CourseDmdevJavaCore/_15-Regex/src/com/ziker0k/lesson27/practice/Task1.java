package com.ziker0k.lesson27.practice;

public class Task1 {
    public static void main(String[] args) {
        String x = "ziker0k@yandex.com";
        System.out.println(x);
        System.out.println(isItEmail(x));

    }

    public static boolean isItEmail(String string) {
        return string.matches("[a-zA-Z]\\w*@\\w{3,}\\.(org|com)");
    }
}
