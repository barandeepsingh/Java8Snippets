package com.baran.java8.samples.loops;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class LoopsDemo {
    public static void main(String[] args) {
        int start = 1;
        int end = 1_000_000_000;
        System.out.println(Runtime.getRuntime().availableProcessors());
        LocalDateTime startTime = LocalDateTime.now();
        log.info("Started execution");
        int sum = IntStream.rangeClosed(start, end).sum();
        log.info("Int stream sum is {}", sum);
        LocalDateTime endTime = LocalDateTime.now();
        log.info("Completed execution in {} milliseconds ", startTime.until((endTime), ChronoUnit.MILLIS));
        log.info("===================");

        startTime = LocalDateTime.now();
        log.info("Started execution");
        sum = IntStream.rangeClosed(start, end).parallel().reduce(0, Integer::sum);
        log.info("Parallel IntStream sum is {}", sum);
        endTime = LocalDateTime.now();
        log.info("Completed execution in {} milliseconds ", startTime.until((endTime), ChronoUnit.MILLIS));
        log.info("===================");

        startTime = LocalDateTime.now();
        log.info("Started execution");
        sum = Stream.iterate(0,n->n+1).limit(end).reduce(0,(a,b)->(a+b));
        log.info("Stream iterate sum is {}", sum);
        endTime = LocalDateTime.now();
        log.info("Completed execution in {} milliseconds ", startTime.until((endTime), ChronoUnit.MILLIS));
        log.info("===================");


        startTime = LocalDateTime.now();
        sum = 0;
        log.info("Started execution");
        for (int i = 0; i < end; i++) {
            sum += i;
        }
        log.info("For loop sum is {}", sum);
        endTime = LocalDateTime.now();
        log.info("Completed execution in {} milliseconds ", startTime.until((endTime), ChronoUnit.MILLIS));
        log.info("===================");


    }
}
