package com.baran.java8.samples.designpatterns.behavioural.visitor;

public interface ShoppingCartVisitor {
        Item visit(Fruit fruit);
        Item visit(Mobile mobile);
}
