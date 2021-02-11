package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker aTracker = new Tracker();
        aTracker.add(new Item(1, "Переставить"));
        Item found = aTracker.findById(1);
        if (found != null) {
            System.out.println("id: " + found.getId()
                    + ", name: " + found.getName());
        } else {
            System.out.println("null");
        }
    }
}
