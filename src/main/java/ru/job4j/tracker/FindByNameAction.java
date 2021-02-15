package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] rsl = tracker.findByName(input.askStr("Enter name: "));
        if (rsl.length > 0) {
            for (Item item : rsl) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Items with this name not found");
        }
        return true;
    }
}
