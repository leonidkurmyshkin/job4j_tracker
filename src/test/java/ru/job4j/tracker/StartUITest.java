package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final String ln = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Fix PC", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Fix PC"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Fix PC"));
        String replacedName = "Wash the floor";
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(item.getId()),
                replacedName,
                "1"
        });
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(item.getId()),
                "1"
        });
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. === Exit ===" + ln
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Fix PC"));
        Item item2 = tracker.add(new Item("Replace cartridge"));
        Input in = new StubInput(new String[] {"0", "1"});
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. === Show all Items ===" + ln
                + "1. === Exit ===" + ln
                + item1.toString() + ln
                + item2.toString() + ln
                + "Menu." + ln
                + "0. === Show all Items ===" + ln
                + "1. === Exit ===" + ln
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Fix PC"));
        Item item2 = tracker.add(new Item("Replace cartridge"));
        Input in = new StubInput(new String[] {
                "0",
                item2.getName(),
                "1"
        });
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. === Find Items by Name ===" + ln
                        + "1. === Exit ===" + ln
                        + item2.toString() + ln
                        + "Menu." + ln
                        + "0. === Find Items by Name ===" + ln
                        + "1. === Exit ===" + ln
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Fix PC"));
        Item item2 = tracker.add(new Item("Replace cartridge"));
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(item1.getId()),
                "1"
        });
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. === Find an Item by ID ===" + ln
                        + "1. === Exit ===" + ln
                        + item1.toString() + ln
                        + "Menu." + ln
                        + "0. === Find an Item by ID ===" + ln
                        + "1. === Exit ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + ln
                + "0. === Exit ===" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu." + ln
                + "0. === Exit ===" + ln
        ));
    }
}
