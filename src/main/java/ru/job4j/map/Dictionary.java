package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String string: strings) {
            char symbol = string.charAt(0);
            rsl.putIfAbsent(Character.toString(symbol), new ArrayList<>());
            rsl.get(Character.toString(symbol)).add(string);
        }
        return rsl;
    }
}