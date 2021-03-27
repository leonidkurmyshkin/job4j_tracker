package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converting {
    public static List<Integer> numMatrixToList(Integer[][] numbers) {
        return Stream.of(numbers)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
