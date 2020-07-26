package com.baran.java8.samples.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class MapOverwriteValueDemo {
    public static void main(String[] args) {
        Map<String, String> mapTest = new HashMap<>();
        mapTest.put("Apple", "11 Pro Max");
        mapTest.put("Apple", "XR");
        mapTest.put("Apple", "SE 2020");
        mapTest.put("Apple", "8 plus");
        mapTest.put("OnePlus", "Nord");
        mapTest.put("OnePlus", "8 Pro");
        mapTest.put("OnePlus", "5");
        mapTest.forEach((k, v) -> log.info("Key::" + k + "::::Value::" + v));

    }
}
