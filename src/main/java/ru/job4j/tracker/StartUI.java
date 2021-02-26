package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        do {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. "
                        + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        } while (run);
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        int index = 0;
        for (UserAction action : actions) {
            out.println((index++) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = Tracker.getInstance();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ShowAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction()
        );
        new StartUI(output).init(input, tracker, actions);
    }
}