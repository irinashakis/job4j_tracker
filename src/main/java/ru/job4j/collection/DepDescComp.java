package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] firstDep = o1.split("/");
        String[] otherDep = o2.split("/");
        int result = otherDep[0].compareTo(firstDep[0]);
        return (result == 0) ? o1.compareTo(o2) : result;
    }
}