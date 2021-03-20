package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] sepS1 = s1.split("/", 2);
        String[] sepS2 = s2.split("/", 2);
        int rsl = sepS2[0].compareTo(sepS1[0]);
        return rsl == 0 ? s1.compareTo(s2) : rsl;
    }
}