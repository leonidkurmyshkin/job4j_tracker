package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftWords = left.split("\\.");
        String[] rightWords = right.split("\\.");
        int cmpResult = 0;
        for (int i = 0; i < Math.min(leftWords.length, rightWords.length); i++) {
            int leftNumber, rightNumber;
            try {
                leftNumber = Integer.parseUnsignedInt(leftWords[i]);
            } catch (NumberFormatException e) {
                leftNumber = -1;
            }
            try {
                rightNumber = Integer.parseUnsignedInt(rightWords[i]);
            } catch (NumberFormatException e) {
                rightNumber = -1;
            }
            if (leftNumber == -1 && rightNumber == -1) {
                break;
            }
            cmpResult = Integer.compare(leftNumber, rightNumber);
            if (cmpResult != 0) {
                break;
            }
        }
        return cmpResult;
    }
}