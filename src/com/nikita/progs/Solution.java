package com.nikita.progs;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(getCountTheSameFirstName(createMap(), "Sergey"));
        System.out.println(getCountTheSameLastName(createMap(), "Popov"));
    }

    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Sergey", "Popov");
        map.put("Sergey", "Sergeev");
        map.put("Yuri", "Sergeev");
        map.put("Sergey", "Sergeev");
        map.put("Alex", "Jackson");
        map.put("Michael", "Popov");
        map.put("Mark", "Popov");
        map.put("Yuri", "Ivanov");
        map.put("Yuri", "Zaycev");
        map.put("Sergey", "Popov");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int howSameNames = 0;
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            if (key.equals(name))
                howSameNames++;
        }
        return howSameNames;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int howSameLastNames = 0;
        for (Map.Entry<String, String> entry : map.entrySet()){
            String value = entry.getValue();
            if (value.equals(lastName))
                howSameLastNames++;
        }
        return howSameLastNames;
    }
}