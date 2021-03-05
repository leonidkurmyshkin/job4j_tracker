package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (int i = 1; i <= surname.size(); i++) {
            name.computeIfPresent(i, (key, value) -> value + ' ' + surname.get(key));
        }
        return name;
    }
}