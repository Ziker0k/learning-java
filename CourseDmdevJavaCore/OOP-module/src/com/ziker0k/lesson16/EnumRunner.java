package com.ziker0k.lesson16;

public class EnumRunner {
    public static void main(String[] args) {
        ProcessorType processorType = ProcessorType.BIT_32;
        System.out.println(processorType.getDescription());
    }
}
