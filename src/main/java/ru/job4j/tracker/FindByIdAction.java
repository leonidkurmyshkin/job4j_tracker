package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find an Item by ID ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item rsl = tracker.findById(input.askInt("Enter Id: "));
        if (rsl != null) {
            out.println(rsl.toString());
        } else {
            out.println("Item with this Id not found");
        }
        return true;
    }
}
