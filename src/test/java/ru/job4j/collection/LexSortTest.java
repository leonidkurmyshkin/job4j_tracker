package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortDiffNumLength() {
        String[] input = {
                "1.10.",
                "1.10.5.",
                "1.2.",
                "Task."
        };
        String[] out = {
                "Task.",
                "1.2.",
                "1.10.",
                "1.10.5."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}