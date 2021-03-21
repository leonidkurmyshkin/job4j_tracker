package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionComp {
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> yX = new ArrayList<>();
        for (int x = start; x < end; x++) {
            yX.add(func.apply((double) x));
        }
        return yX;
    }
}
