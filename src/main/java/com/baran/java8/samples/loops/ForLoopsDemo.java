package com.baran.java8.samples.loops;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Slf4j
public class LongStreamLoopsDemo {
    public static void main(String[] args) {
        long start = 1;
        long end = 1_000_000_000;
        LocalDateTime startTime = LocalDateTime.now();
        log.info("Started execution");
        long sum = LongStream.rangeClosed(start, end).sum();
        log.info("Int stream sum is {}", sum);
        LocalDateTime endTime = LocalDateTime.now();
        log.info("Completed execution in {} milliseconds ", startTime.until((endTime), ChronoUnit.MILLIS));
        log.info("===================");

    }
}
