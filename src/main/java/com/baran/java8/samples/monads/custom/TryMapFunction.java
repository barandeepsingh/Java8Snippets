package com.baran.java8.samples.monads.custom;

public interface TryMapFunction<T, R> {
    R apply(T t) throws Throwable;
}
