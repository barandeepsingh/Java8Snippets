package com.baran.java8.samples.designpatterns.behavioural.visitor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fruit implements Item {
    private String name;
    private int price;
    private String color;

    @Override
    public Item accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
