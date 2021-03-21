package com.baran.java8.samples.monads.custom;

@FunctionalInterface
public interface TryFunction<T, R> {
    R apply(T t) throws Throwable;
}
