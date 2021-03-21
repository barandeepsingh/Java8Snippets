package com.baran.java8.samples.monads.custom;

/**
 * This is similar to the Java Supplier function type.
 * It has a checked exception on it to allow it to be used in lambda expressions on the Try monad.
 *
 * @param <T>
 */
@FunctionalInterface
public interface TrySupplier<T> {
    T get() throws Throwable;
}
