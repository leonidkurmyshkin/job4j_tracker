package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id: ");
        Item item = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, item)) {
            System.out.println("Item edited successfully");
        } else {
            System.out.println("Edit error");
        }
        return true;
    }
}
