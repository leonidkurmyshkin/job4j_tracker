package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] rsl = tracker.findAll();
        if (rsl.length > 0) {
            for (Item item : rsl) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Items not found");
        }
        return true;
    }
}
