package ru.job4j.set;

import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String[] sWords = s.split(" ");
        boolean isContains = false;
        for (String word : sWords) {
            if (words.contains(word)) {
                isContains = true;
                break;
            }
        }
        return isContains
                ? "Выберите другую статью..."
                : "Вы сделали правильный выбор!";
    }
}