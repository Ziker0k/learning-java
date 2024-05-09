package com.ziker0k.lesson19.homework.task2.car;

import java.util.Objects;

public class Bus extends Car {
    private int capacity;

    public Bus(int year, Brand brand, Model model, Color color, Engine engine, int capacity) {
        super(year, brand, model, color, engine);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "capacity=" + capacity +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return capacity == bus.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    public int getCapacity() {
        return capacity;
    }
}
