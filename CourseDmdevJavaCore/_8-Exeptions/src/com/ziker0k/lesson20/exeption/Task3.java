package com.ziker0k.lesson20.exeption;

public class Task3 {
    public static void main(String[] args) {
        try {
            methodWithMyException();
        } catch (Ziker0kException exception) {
            exception.printStackTrace();
        }
    }

    public static void methodWithMyException() throws Ziker0kException {
        throw new Ziker0kException("dsdsd");
    }
}
