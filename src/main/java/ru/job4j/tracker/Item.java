package ru.job4j.tracker;

import java.time.LocalDateTime;
/*import java.util.Arrays;*/

public class Item {
    private int id;
    private String name;

    private LocalDateTime created = LocalDateTime.now();

    /* private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;*/

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

  /*  public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] newItems = Arrays.copyOf(items, size);
        return newItems;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}