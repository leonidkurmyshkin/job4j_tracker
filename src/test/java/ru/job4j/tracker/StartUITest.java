package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Fix PC", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        List<Item> allList = tracker.findAll();
        assertThat(allList.get(0).getName(), is("Fix PC"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Fix PC"));
        String replacedName = "Wash the floor";
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(item.getId()),
                replacedName,
                "1"
        });
        List<UserAction> actions = List.of(
                new ReplaceAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(item.getId()),
                "1"
        });
        List<UserAction> actions = List.of(
                new DeleteAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                + "0. === Exit ===" + LN
        ));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item1 = tracker.add(new Item("Fix PC"));
        Item item2 = tracker.add(new Item("Replace cartridge"));
        Input in = new StubInput(new String[] {"0", "1"});
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                + "0. === Show all Items ===" + LN
                + "1. === Exit ===" + LN
                + item1.toString() + LN
                + item2.toString() + LN
                + "Menu." + LN
                + "0. === Show all Items ===" + LN
                + "1. === Exit ===" + LN
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item1 = tracker.add(new Item("Fix PC"));
        Item item2 = tracker.add(new Item("Replace cartridge"));
        Input in = new StubInput(new String[] {
                "0",
                item2.getName(),
                "1"
        });
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. === Find Items by Name ===" + LN
                        + "1. === Exit ===" + LN
                        + item2.toString() + LN
                        + "Menu." + LN
                        + "0. === Find Items by Name ===" + LN
                        + "1. === Exit ===" + LN
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item1 = tracker.add(new Item("Fix PC"));
        Item item2 = tracker.add(new Item("Replace cartridge"));
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(item1.getId()),
                "1"
        });
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                        + "0. === Find an Item by ID ===" + LN
                        + "1. === Exit ===" + LN
                        + item1.toString() + LN
                        + "Menu." + LN
                        + "0. === Find an Item by ID ===" + LN
                        + "1. === Exit ===" + LN
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", "0"});
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + LN
                + "0. === Exit ===" + LN
                + "Wrong input, you can select: 0 .. 0" + LN
                + "Menu." + LN
                + "0. === Exit ===" + LN
        ));
    }
}
