package com.baran.java8.samples.designpatterns.behavioural.visitor;

public interface Item {
    Item accept(ShoppingCartVisitor visitor);
}
