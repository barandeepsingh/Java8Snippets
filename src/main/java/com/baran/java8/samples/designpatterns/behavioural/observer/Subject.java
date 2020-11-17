package com.baran.java8.samples.designpatterns.behavioural.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Subject {
    private List<Observer> observerList = new ArrayList<>();
    private int status;

    public void setState(int status){
        this.status = status;
        notifyAllObservers();
    }
    public void attach(Observer observer){
        observerList.add(observer);
    }
    public void detach(Observer observer){
        observerList.remove(observer);
    }

    private void notifyAllObservers() {
        observerList.forEach(Observer::update);
    }
}
