package com.baran.java8.samples.designpatterns.behavioural.visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mobile implements Item {
    private String name;
    private String brand;
    private int price;

    @Override
    public Item accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
