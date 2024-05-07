package com.ziker0k.oop.lesson18.hw;

/**
 * 1. Создать класс Pair, параметризованный двумя
 * параметрами K и V. Класс должен хранить две
 * переменные типов K и V соответственно. У
 * класса должен быть конструктор,
 * принимающий 2 параметра типов K и V, а
 * также набор соответствующих
 * геттеров/сеттеров, toString (для отображения состояния
 * текущего объекта типа Pair)
 * <p>
 * 2. Создать статический обобщённый метод swap
 * в утилитном классе PairUtil (утилитный класс – это класс
 * только со статическими методами, который имеет
 * private конструктор и помечен ключевым словом final,
 * чтобы предотвратить создание объектов этого класса,
 * а также наследоваться от него). Метод должен
 * принимать объект класса Pair и возвращать
 * новый объект Pair, в которой элементы поменяны местами.
 */

public class PairRunner {
    public static void main(String[] args) {
        Pair<String, Double> stringDoublePair = new Pair<>("Hello", 124.3);
        System.out.println(stringDoublePair);
        Pair<?, ?> doubleStringPair = PairUtil.swap(stringDoublePair);
        System.out.println(doubleStringPair);
    }
}
