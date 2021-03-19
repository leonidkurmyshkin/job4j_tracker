package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int indexS1 = s1.indexOf('/');
        if (indexS1 == -1) {
            indexS1 = s1.length();
        }
        int indexS2 = s2.indexOf('/');
        if (indexS2 == -1) {
            indexS2 = s2.length();
        }
        int rsl = s2.substring(0, indexS2)
                .compareTo(s1.substring(0, indexS1));
        if (rsl == 0) {
            rsl = s1.substring(indexS1)
                    .compareTo(s2.substring(indexS2));
        }
        return rsl;
    }
}