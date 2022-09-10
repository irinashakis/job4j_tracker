package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
    Item item = new Item();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    String createdDateTimeFormat = item.getCreated().format(formatter);
    System.out.println(createdDateTimeFormat);

    Item user = new Item(1, "Item");
    System.out.println(user);
    }
}
