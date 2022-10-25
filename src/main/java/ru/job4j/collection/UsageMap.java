package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@mail.ru", "Ivanov Ivan");
        map.put("petrov@gmail.com", "Petrov Andrey");
        map.put("smi888@mail.ru", "Semyonov Semen");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
