package com.baran.java8.samples.loops;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Slf4j
public class LongStreamLoopsDemo {
    public static void main(String[] args) {
        List<Long> timeToProcess = new ArrayList<>();
        long start = 1;
        long end = 1_000_000_000;
        log.info("Started execution");
        for (int i = 0; i < 100; i++) {
            LocalDateTime startTime = LocalDateTime.now();
            long sum = LongStream.rangeClosed(start, end).sum();
//            log.info("Int stream sum is {}", sum);
            LocalDateTime endTime = LocalDateTime.now();
            long until = startTime.until((endTime), ChronoUnit.MILLIS);
            timeToProcess.add(until);
            log.info("Completed execution in {} milliseconds ", until);
//            log.info("===================");
        }
        log.info("Min time is " + timeToProcess.stream().sorted().findFirst().get());

    }
}
