package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(1, "Переставить");
        Item item2 = new Item(2, "Принести");
        Item item3 = new Item(3, "Подать");
        Item item4 = new Item(4, "Переставить");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] exp = new Item[2];
        exp[0] = item1;
        exp[1] = item4;
        assertThat(tracker.findByName("Переставить"), is(exp));
    }
}