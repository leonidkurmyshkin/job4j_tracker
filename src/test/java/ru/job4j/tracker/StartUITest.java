package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        //StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Wash the floor");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "Wash the windows"
        };
        //StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        Item expected = new Item("Wash the windows");
        assertThat(replaced.getName(), is(expected.getName()));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Wash the floor");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()) };
        //StartUI.deleteItem(new StubInput(answers), tracker);
        Item rsl = tracker.findById(item.getId());
        assertNull(rsl);
    }
}