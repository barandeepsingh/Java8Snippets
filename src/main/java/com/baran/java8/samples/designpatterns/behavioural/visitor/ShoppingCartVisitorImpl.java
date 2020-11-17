package com.baran.java8.samples.designpatterns.behavioural.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{
    @Override
    public Item visit(Fruit fruit) {
        if(fruit.getPrice()>200){
            log.info("Imported fruit adding tax");
            fruit.setPrice(fruit.getPrice()+10);
        }
        return fruit;
    }

    @Override
    public Item visit(Mobile mobile) {
        if(mobile.getBrand().equalsIgnoreCase("Apple")){
            log.info("You have to pay double for Apple products In India.");
            mobile.setPrice(mobile.getPrice()*2);
        }
        return mobile;
    }
}
