package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(5, -2, 4, 1, -3));
        List<Integer> rslNumbers = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
    }
}
