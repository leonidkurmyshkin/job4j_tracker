package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@mail.ru", "Ivanov Petr");
        map.put("sokolov@gmail.com", "Sokolov Dmitry");
        map.put("wiki@mail.ru", "Dobronravov Ilya");
        for (String key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }
    }
}
