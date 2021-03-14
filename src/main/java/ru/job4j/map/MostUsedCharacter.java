package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        TreeMap<Character, Integer> charFreq = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (symbol == ' ') {
                continue;
            }
            if (Character.isUpperCase(symbol)) {
                symbol = Character.toLowerCase(symbol);
            }
            if (charFreq.putIfAbsent(symbol, 1) != null) {
                charFreq.computeIfPresent(symbol, (key, value) -> value += 1);
            }
        }
        Character keyOfMaxCount = charFreq.firstKey();
        for (Character tmpChar : charFreq.keySet()) {
            if (charFreq.get(tmpChar) > charFreq.get(keyOfMaxCount)) {
                keyOfMaxCount = tmpChar;
            }
        }
        return keyOfMaxCount;
    }
}