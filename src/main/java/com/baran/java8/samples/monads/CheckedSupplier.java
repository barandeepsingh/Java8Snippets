package com.baran.java8.samples.monads;

@FunctionalInterface
public interface CheckedSupplier<V, E extends Throwable> {
    V get() throws E;
}