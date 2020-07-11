package com.baran.java8.samples.Optional;

import java.util.Optional;

public class ChainingOptionalsMap {
    public static Double multiplyBy2(double n) {
        return n * 2;
    }

    public static Double divideBy3(double n) {
        return n / 3;
    }

    public static Double round(double n) {
        return (double) Math.round(n);
    }

    public static Optional<Double> applyOperation(double n1) {
        return Optional.of(n1).map(ChainingOptionalsMap::multiplyBy2).map(ChainingOptionalsMap::divideBy3).map(ChainingOptionalsMap::round);
    }

    public static void main(String[] args) {
        System.out.println("Output = " + applyOperation(12).get());
    }
}
