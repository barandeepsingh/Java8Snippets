package com.baran.java8.samples.designpatterns.behavioural.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
