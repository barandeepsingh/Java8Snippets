package com.baran.java8.samples.designpatterns.behavioural.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);

    }
    @Override
    public void update() {
      log.info("The value got updated : Binary value is {}",Integer.toBinaryString(subject.getStatus()));
    }
}
