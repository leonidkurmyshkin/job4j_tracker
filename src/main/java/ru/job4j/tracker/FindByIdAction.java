package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find an Item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item rsl = tracker.findById(input.askInt("Enter Id: "));
        if (rsl != null) {
            System.out.println(rsl.toString());
        } else {
            System.out.println("Item with this Id not found");
        }
        return true;
    }
}
