package com.ziker0k.lesson19.homework.task2.car;

import java.util.Objects;

public class SportCar extends Car {
    private int competitions;

    public SportCar(int year, Brand brand, Model model, Color color, Engine engine, int competitions) {
        super(year, brand, model, color, engine);
        this.competitions = competitions;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "competitions=" + competitions +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportCar sportCar = (SportCar) o;
        return competitions == sportCar.competitions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), competitions);
    }

    public int getCompetitions() {
        return competitions;
    }

    public void addCompetition() {
        this.competitions += 1;
    }
}
