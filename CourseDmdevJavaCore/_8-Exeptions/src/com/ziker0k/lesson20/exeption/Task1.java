package com.ziker0k.lesson20.exeption;

public class Task1 {
    public static void main(String[] args) {
        String s = null;
        try {
            s.length();
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}
