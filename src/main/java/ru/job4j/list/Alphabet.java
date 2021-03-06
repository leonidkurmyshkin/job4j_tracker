package ru.job4j.list;

import java.util.*;

public class Alphabet {
    public static String reformat(String s) {
        List<String> chars = new ArrayList<>(Arrays.asList(s.split("")));
        Collections.sort(chars, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder word = new StringBuilder(s.length());
        for (String symbol : chars) {
            word.append(symbol);
        }
        return word.toString();
    }
}