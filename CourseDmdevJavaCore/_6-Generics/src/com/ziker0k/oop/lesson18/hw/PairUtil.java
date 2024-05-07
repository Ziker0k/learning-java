package com.ziker0k.oop.lesson18.hw;

/**
 * 2. Создать статический обобщённый метод swap
 * в утилитном классе PairUtil (утилитный класс – это класс
 * только со статическими методами, который имеет
 * private конструктор и помечен ключевым словом final,
 * чтобы предотвратить создание объектов этого класса,
 * а также наследоваться от него). Метод должен
 * принимать объект класса Pair и возвращать
 * новый объект Pair, в которой элементы поменяны местами.
 */

public final class PairUtil {
    private PairUtil() {
    }

    public static <K, V> Pair<V, K> swap(Pair<K, V> source) {
        K value1 = source.getValue1();
        V value2 = source.getValue2();
        return new Pair<>(value2, value1);
    }
}
