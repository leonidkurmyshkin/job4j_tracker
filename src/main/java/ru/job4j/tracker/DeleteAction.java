package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id: ");
        if (tracker.delete(id)) {
            out.println("Item deleted successfully");
        } else {
            out.println("Delete error");
        }
        return true;
    }
}
