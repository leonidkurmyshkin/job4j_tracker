package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id: ");
        Item item = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id, item)) {
            out.println("Item edited successfully");
        } else {
            out.println("Edit error");
        }
        return true;
    }
}
