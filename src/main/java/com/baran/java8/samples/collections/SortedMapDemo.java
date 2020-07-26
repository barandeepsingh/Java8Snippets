package com.baran.java8.samples.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class SortedMapDemo {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Jayant", 80);
        map.put("Abhishek", 90);
        map.put("Anushka", 80);
        map.put("Amit", 75);
        map.put("Danish", 40);

        getSortedMap().forEach((k, v) -> log.info("Student " + k + " :: Marks " + v));
    }

    public static Map<String, Integer> getSortedMap() {
        return new TreeMap<>(map);
    }
}
