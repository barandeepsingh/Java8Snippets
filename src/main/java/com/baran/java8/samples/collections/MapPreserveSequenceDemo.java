package com.baran.java8.samples.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class MapPreserveSequenceDemo {
    public static void main(String[] args) {
        Map<String, String> mapTest = new LinkedHashMap<>();
        mapTest.put("Apple", "11 Pro Max");
        mapTest.put("OnePlus", "8 Pro");
        mapTest.put("Samsung", "Galaxy S20");
        mapTest.put("HTC", "U11");

        mapTest.forEach((k, v) -> log.info("Key::" + k + "::::Value::" + v));

    }
}
