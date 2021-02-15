package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete an Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Id: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Delete error");
        }
        return true;
    }
}
