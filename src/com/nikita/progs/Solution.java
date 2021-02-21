package com.nikita.progs;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        Map<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

        Calendar calendar = new GregorianCalendar();
        System.out.println("This is " + calendar.DAY_OF_WEEK);
    }


    public static Map<String, Cat> addCatsToMap(String[] cats) {
        Map<String, Cat> list = new HashMap<String, Cat>();
        for (String s : cats) {
            list.put(s, new Cat(s));
        }
        return list;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}