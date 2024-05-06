package com.ziker0k.lesson16;

public enum ProcessorType implements Describable {
    BIT_32("bit_32"),
    BIT_64("bit_64");

    private final String name;

    ProcessorType(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name + " description";
    }

    public String getName() {
        return name;
    }
}
