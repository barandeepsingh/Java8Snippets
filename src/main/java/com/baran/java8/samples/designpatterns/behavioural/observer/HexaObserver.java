package com.baran.java8.samples.designpatterns.behavioural.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HexaObserver extends Observer{
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);

    }
    @Override
    public void update() {
      log.info("The value got updated : Hexa value is {}",Integer.toHexString(subject.getStatus()));
    }
}
