package com.baran.java8.samples.loops;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ForIntClassLoopsDemo {
    public static void main(String[] args) {
        List<Long> timeToProcess = new ArrayList<>();
        Integer end = 1_000_000_000;
        Integer sum=0;
        log.info("Started execution");
        for (Integer i = 0; i < 1; i++) {
            LocalDateTime startTime = LocalDateTime.now();
            for (Integer j = 0; j < end; j++) {
                sum += j;
//                log.info("Int stream sum is {}", sum);
            }
            LocalDateTime endTime = LocalDateTime.now();
            long until = startTime.until((endTime), ChronoUnit.MILLIS);
            timeToProcess.add(until);
//            log.info("Completed execution in {} milliseconds ", until);
//            log.info("===================");
        }
        log.info("Min time is " + timeToProcess.stream().findFirst().get());

    }
}
