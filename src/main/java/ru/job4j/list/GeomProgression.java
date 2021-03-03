package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> geomProgression = new ArrayList<>(count);
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int element = first * (int) Math.pow(denominator, i);
            geomProgression.add(i, element);
            sum += element;
        }
        return sum;
    }
}