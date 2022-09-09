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
        copy = Arrays.copyOf(items, size);
        return copy;
    }

    public Item[] findByName(String key) {
        Item[] newItems = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                Item newItem = items[index];
                if (newItem.getName().equals(key)) {
                    newItems[size] = newItem;
                    size++;
                }
            }
        }
        newItems = Arrays.copyOf(items, size);
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

