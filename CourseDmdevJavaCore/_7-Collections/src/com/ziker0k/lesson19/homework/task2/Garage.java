package com.ziker0k.lesson19.homework.task2;

import com.ziker0k.lesson19.homework.task2.car.Brand;
import com.ziker0k.lesson19.homework.task2.car.Car;
import com.ziker0k.lesson19.homework.task2.car.Color;

import java.util.HashMap;
import java.util.Map;

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
public class Garage {
    private final HashMap<Car, Integer> cars = new HashMap<>();

    public void park(Car car) {
        int oldCount = cars.getOrDefault(car, 0);
        cars.put(car, oldCount + 1);
    }

    public void departure(Car car) {
        if (cars.containsKey(car)) {
            removeCarFromGarage(car);
        } else {
            System.out.println("Такой машины в гараже нет!");
        }
    }

    public int getCarCountByColor(Color color) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
            if (entry.getKey().getColor() == color) result += entry.getValue();
        }
        return result;
    }

    public int getCarCountByBrand(Brand brand) {
        int result = 0;
        for (Map.Entry<Car, Integer> entry : cars.entrySet()) {
            if (entry.getKey().getBrand() == brand) result += entry.getValue();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "cars=" + cars +
                '}';
    }

    private void removeCarFromGarage(Car car) {
        int count = cars.get(car);
        if (count <= 1) cars.remove(car);
        else {
            cars.put(car, count - 1);
        }
    }
}
