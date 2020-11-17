package com.baran.java8.samples.designpatterns.behavioural.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        log.info("First state change: 15");
        subject.setState(15);
        log.info("Second state change: 10");
        subject.setState(10);
    }
}
