package ru.job4j.tracker;

import java.util.List;

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
        List<Item> rsl = tracker.findAll();
        if (rsl.size() != 0) {
            for (Item item : rsl) {
                out.println(item.toString());
            }
        } else {
            out.println("Items not found");
        }
        return true;
    }
}
