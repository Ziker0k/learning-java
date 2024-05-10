package com.ziker0k.lesson21;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {

    }

    public static class IntegerComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }
}
