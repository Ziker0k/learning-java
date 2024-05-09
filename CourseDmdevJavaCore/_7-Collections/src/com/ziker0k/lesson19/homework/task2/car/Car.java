package com.ziker0k.lesson19.homework.task2.car;

import java.util.Objects;

/**
 * 2. Создать абстрактный класс Car, представляющий собой автомобиль.
 * Добавить в него поля: марка, модель, год выпуска + несколько своих.
 * Создать 4 класса, являющихся наследниками Car.
 * Переопределить во всех 3-х классах методы equals(), hashCode() и toString()
 * Создать класс Garage, хранящий в себе HashMap автомобилей,
 * в котором ключом является объект автомобиля, значением - количество точно таких автомобилей в гараже.
 * Добавить в класс Garage методы для парковки, выезда авто, а также для получения количества определенного вида автомобилей.
 * Продемонстрировать работу гаража.
 */

public abstract class Car {
    private int year;
    private Brand brand;
    private Model model;
    private Color color;
    private Engine engine;

    public Car(int year, Brand brand, Model model, Color color, Engine engine) {
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && engine == car.engine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, brand, model, color, engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", brand=" + brand +
                ", model=" + model +
                ", color=" + color +
                ", engine=" + engine +
                '}';
    }

    public int getYear() {
        return year;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }
}