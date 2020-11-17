package com.baran.java8.samples.loops;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ForLoopsDemo {
    public static void main(String[] args) {
        List<Long> timeToProcess = new ArrayList<>();
        int sum = 0;
        int end = 1_000_000_000;
        log.info("Started execution");
        for (int i = 0; i < 1; i++) {
            LocalDateTime startTime = LocalDateTime.now();
            for (int j = 0; j < end; j++) {
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
