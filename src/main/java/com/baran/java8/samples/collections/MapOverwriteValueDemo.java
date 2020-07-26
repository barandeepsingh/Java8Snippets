package com.baran.java8.samples.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
public class MapOverwriteValueDemo {
    private static final String APPLE = "Apple";
    private static final String ONEPLUS = "OnePlus";

    public static void main(String[] args) {

        Map<String, String> mapTest = new HashMap<>();
        mapTest.put(APPLE, "11 Pro Max");
        mapTest.put(APPLE, "XR");
        mapTest.put(APPLE, "SE 2020");
        mapTest.put(APPLE, "8 plus");
        mapTest.put(ONEPLUS, "Nord");
        mapTest.put(ONEPLUS, "8 Pro");
        mapTest.put(ONEPLUS, "5");
        mapTest.forEach((k, v) -> log.info("Key::" + k + "::::Value::" + v));

    }
}
