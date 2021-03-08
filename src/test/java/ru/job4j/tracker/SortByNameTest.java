package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

public class SortByNameTest {
    @Test
    public void whenAscItemsSort() {
        Tracker tracker = Tracker.getInstance();
        tracker.add(new  Item("Draw"));
        tracker.add(new Item("Check"));
        tracker.add(new Item("Replace"));
        tracker.findAll().sort(new AscSortByName());
        List<Item> expected = List.of(
                new Item("Check"),
                new Item("Draw"),
                new Item("Replace")
        );
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenDescItemsSort() {
        Tracker tracker = Tracker.getInstance();
        tracker.add(new  Item("Draw"));
        tracker.add(new Item("Check"));
        tracker.add(new Item("Replace"));
        tracker.findAll().sort(new DescSortByName());
        List<Item> expected = List.of(
                new Item("Replace"),
                new Item("Draw"),
                new Item("Check")
        );
        assertThat(tracker.findAll(), is(expected));
    }
}
