package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> originWords = new HashSet<>(
                List.of(origin.split("[ ?!,.;:]"))
        );
        Set<String> lineWords = new HashSet<>(
                List.of(line.split("[ ?!,.;:]"))
        );
        return originWords.containsAll(lineWords);
    }
}