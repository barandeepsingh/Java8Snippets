package com.baran.java8.samples.Optional;

import java.util.Optional;

public class ChainingOptionals {
    public static Optional<Integer> divideBy2(final int num) {
        return Optional.ofNullable(num / 2);
    }

    public static Optional<Integer> multiplyBy3(final int num) {
        return Optional.ofNullable(num * 3);
    }

    public static Optional<Integer> add4(final int num) {
        return Optional.ofNullable(num + 4);
    }

    public static Optional<Integer> computeResult() {
        return add4(5).flatMap(ChainingOptionals::divideBy2).flatMap(ChainingOptionals::multiplyBy3);
    }

    public static void main(String[] args) {
        computeResult().ifPresent(System.out::println);
    }
}
