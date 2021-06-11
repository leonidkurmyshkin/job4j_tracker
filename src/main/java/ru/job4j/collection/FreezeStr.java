package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for (var i = 0; i < left.length(); i++) {
            symbolsMap.compute(left.charAt(i),
                    (symbol, amount) -> amount == null ? 1 : amount + 1);
        }
        var rsl = true;
        for (var i = 0; rsl && i < right.length(); i++) {
            rsl = symbolsMap.compute(right.charAt(i),
                    (symbol, amount) -> amount == null ? -1 : amount - 1)
                    >= 0;
        }
        return rsl;
    }
}