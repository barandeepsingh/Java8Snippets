package com.baran.java8.samples.designpatterns.behavioural.visitor;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class VisitorMain {
    public static void main(String[] args) {
        List<Item> itemList = Arrays.asList(new Fruit("Apple", 220, "Red"), new Fruit("Mango", 100, "Yellow"), new Fruit("Banana", 40, "Yellow"),new Mobile("iPhone 12 Pro Max","Apple",75_000),new Mobile("8T","OnePlus",45_000),new Mobile("Pixel 4a","Google",32_500));
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        itemList.forEach(item -> log.info(item.accept(visitor).toString()));
    }
}
