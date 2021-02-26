package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Items by Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> rsl = tracker.findByName(input.askStr("Enter name: "));
        if (rsl != null) {
            for (Item item : rsl) {
                out.println(item.toString());
            }
        } else {
            out.println("Items with this name not found");
        }
        return true;
    }
}
