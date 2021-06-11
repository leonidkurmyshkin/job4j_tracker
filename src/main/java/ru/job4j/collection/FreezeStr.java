package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for (var i = 0; i < left.length(); i++) {
            var symbol = left.charAt(i);
            symbolsMap.computeIfPresent(symbol,
                    (key, amount) -> amount + 1);
            symbolsMap.putIfAbsent(symbol, 1);
        }
        for (var i = 0; i < right.length(); i++) {
            var symbol = right.charAt(i);
            symbolsMap.computeIfPresent(symbol,
                    (key, amount) -> amount - 1);
            symbolsMap.remove(symbol, 0);
        }
        return symbolsMap.isEmpty();
    }
}