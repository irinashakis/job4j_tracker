package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemADescByNameTest {
    @Test
    void whenSortItemAsc() {
        Item itemOne = new Item(1, "Elizaveta");
        Item itemTwo = new Item(2, "Marina");
        Item itemThree = new Item(4, "Svetlana");
        Item itemFour = new Item(3, "Olga");
        List<Item> items = Arrays.asList(itemOne, itemTwo, itemThree, itemFour);
        List<Item> expected = Arrays.asList(itemThree, itemFour, itemTwo, itemOne);
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }

}