package com.ziker0k.lesson19.homework.task2;

import com.ziker0k.lesson19.homework.task2.car.*;

public class GarageRunner {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car supra1 = new SportCar(2000, Brand.TOYOTA, Model.HATCHBACK, Color.BLACK, Engine.JZ_GTE, 0);
        SportCar supra2 = new SportCar(2000, Brand.TOYOTA, Model.HATCHBACK, Color.BLACK, Engine.JZ_GTE, 0);
        garage.park(supra1);
        garage.park(supra2);

        System.out.println(garage);

        garage.departure(supra2);
        supra2.addCompetition();

        garage.park(supra2);

        System.out.println(garage);
    }
}
