package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DummyDicTest {

    @Test
    public void engHomeToRus() {
        DummyDic rsl = new DummyDic();
        assertThat("Неизвестное слово home", is(rsl.engToRus("home")));
    }
}