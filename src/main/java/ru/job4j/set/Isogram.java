package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Isogram {
    public static boolean checkString(String s) {
        Set<Character> sChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            sChars.add(s.charAt(i));
        }
        return s.length() == sChars.size();
    }
}