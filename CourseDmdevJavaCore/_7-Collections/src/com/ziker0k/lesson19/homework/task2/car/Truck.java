package com.ziker0k.lesson19.homework.task2.car;

import java.util.Objects;

public class Truck extends Car {
    private final int loadCapacity;

    public Truck(int year, Brand brand, Model model, Color color, Engine engine, int loadCapacity) {
        super(year, brand, model, color, engine);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck track = (Truck) o;
        return loadCapacity == track.loadCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}
