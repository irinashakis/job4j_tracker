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

    public Item[] findAll() {
        Item[] copy = new Item[items.length];
        for (int index = 0; index < size; index++) {
            if (items[index] != null) {
                copy[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] newItems = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item newItem = items[index];
            if (newItem.getName().equals(key)) {
                newItems[count] = newItem;
                count++;
            }
        }
        newItems = Arrays.copyOf(items, count);
        return newItems;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}

