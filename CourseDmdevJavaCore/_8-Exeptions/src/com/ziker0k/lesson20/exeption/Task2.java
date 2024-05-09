package com.ziker0k.lesson20.exeption;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {0, 1};
        try {
            System.out.println(array[2]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }
}
