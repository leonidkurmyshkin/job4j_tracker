package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        do {
            this.showMenu();
            switch (input.askInt("Select: ")) {
                case 0:
                    createItem(input, tracker);
                    break;
                case 1:
                    showAllItems(tracker);
                    break;
                case 2:
                    editItem(input, tracker);
                    break;
                case 3:
                    deleteItem(input, tracker);
                    break;
                case 4:
                    findById(input, tracker);
                    break;
                case 5:
                    findByName(input, tracker);
                    break;
                case 6:
                    run = false;
                    break;
                default:
            }
        } while (run);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        tracker.add(new Item(input.askStr("Enter name: ")));
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== List of all Items ====");
        Item[] items1 = tracker.findAll();
        if (items1.length > 0) {
            printItems(items1);
        } else {
            System.out.println("Items not found");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        int id2 = input.askInt("Enter Id: ");
        Item item2 = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(id2, item2)) {
            System.out.println("Item edited successfully");
        } else {
            System.out.println("Edit error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id3 = input.askInt("Enter Id: ");
        if (tracker.delete(id3)) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Delete error");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find Item ====");
        int id4 = input.askInt("Enter Id: ");
        Item rsl4 = tracker.findById(id4);
        if (rsl4 != null) {
            System.out.println(rsl4.toString());
        } else {
            System.out.println("Item with this Id not found");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find Items ====");
        Item[] rsl5 = tracker.findByName(input.askStr("Enter name: "));
        if (rsl5.length > 0) {
            printItems(rsl5);
        } else {
            System.out.println("Items with this name not found");
        }
    }

    private void showMenu() {
        System.out.println("Menu." + System.lineSeparator()
                + "0. Add new Item" + System.lineSeparator()
                + "1. Show all items" + System.lineSeparator()
                + "2. Edit item" + System.lineSeparator()
                + "3. Delete item" + System.lineSeparator()
                + "4. Find item by Id" + System.lineSeparator()
                + "5. Find items by name" + System.lineSeparator()
                + "6. Exit Program");
    }

    private static void printItems(Item[] items) {
        for (Item anItem : items) {
            System.out.println(anItem.toString());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}