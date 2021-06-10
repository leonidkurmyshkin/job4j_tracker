package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for (var i = 0; i < left.length(); i++) {
            var symbol = left.charAt(i);
            var amount = symbolsMap.putIfAbsent(symbol, 1);
            if (amount != null) {
                symbolsMap.replace(symbol, amount + 1);
            }
        }
        var rsl = true;
        for (var i = 0; i < right.length(); i++) {
            var symbol = right.charAt(i);
            var amount = symbolsMap.get(symbol);
            if (amount == null || amount == 0) {
                rsl = false;
                break;
            }
            symbolsMap.replace(symbol, amount - 1);
        }
        return rsl;
    }
}