package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };
        cmpDescSize.compare("first", "second");
        String[] names = {
                "Ivan",
                "Petr"
        };
        Arrays.sort(names, cmpDescSize);
    }
}
