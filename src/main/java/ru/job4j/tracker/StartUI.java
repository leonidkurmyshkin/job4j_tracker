package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        do {
            this.showMenu();
            System.out.print("Select: ");
            switch (inpInt(scanner)) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    tracker.add(new Item(scanner.nextLine()));
                    break;
                case 1:
                    System.out.println("=== List of all Items ====");
                    Item[] items1 = tracker.findAll();
                    if (items1.length > 0) {
                        printItems(items1);
                    } else {
                        System.out.println("Items not found");
                    }
                    break;
                case 2:
                    System.out.println("=== Edit Item ====");
                    System.out.print("Enter Id: ");
                    int id2 = inpInt(scanner);
                    System.out.print("Enter new name: ");
                    Item item2 = new Item(scanner.nextLine());
                    if (tracker.replace(id2, item2)) {
                        System.out.println("Item edited successfully");
                    } else {
                        System.out.println("Edit error");
                    }
                    break;
                case 3:
                    System.out.println("=== Delete Item ====");
                    System.out.print("Enter Id: ");
                    int id3 = inpInt(scanner);
                    if (tracker.delete(id3)) {
                        System.out.println("Item deleted successfully");
                    } else {
                        System.out.println("Delete error");
                    }
                    break;
                case 4:
                    System.out.println("=== Find Item ====");
                    System.out.print("Enter Id: ");
                    int id4 = inpInt(scanner);
                    Item rsl4 = tracker.findById(id4);
                    if (rsl4 != null) {
                        System.out.println(rsl4.toString());
                    } else {
                        System.out.println("Item with this Id not found");
                    }
                    break;
                case 5:
                    System.out.println("=== Find Items ====");
                    System.out.print("Enter name: ");
                    Item[] rsl5 = tracker.findByName(scanner.nextLine());
                    if (rsl5.length > 0) {
                        printItems(rsl5);
                    } else {
                        System.out.println("Items with this name not found");
                    }
                    break;
                case 6:
                    run = false;
                    break;
                default:
            }
        } while (run);
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

    private void printItems(Item[] items) {
        for (Item anItem : items) {
            System.out.println(anItem.toString());
        }
    }

    private int inpInt(Scanner scanner) {
        return Integer.valueOf(scanner.nextLine());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}