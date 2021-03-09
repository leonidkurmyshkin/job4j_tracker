package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            rsl = left.charAt(i) - right.charAt(i);
            if (rsl != 0) {
                break;
            }
        }
        return rsl != 0 ? rsl : left.length() - right.length();
    }
}