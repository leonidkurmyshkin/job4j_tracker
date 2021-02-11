package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index < 0 ? null : items[index];
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (!(index < 0)) {
            int oldId = items[index].getId();
            items[index] = item;
            items[index].setId(oldId);
        }
        return index < 0 ? false : true;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                rsl[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(rsl, j);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName() == key) {
                rsl[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(rsl, j);
    }
}