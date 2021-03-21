package com.baran.java8.samples.monads;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class Try<V, E extends Throwable> {
    private final V value;
    private final E error;


    public Try(V value, E error) {
        this.value = value;
        this.error = error;
    }

    public static <V, E extends Throwable> Try<V, E> failure(E error) {
        return new Try<>(null, Objects.requireNonNull(error));
    }

    public static <V, E extends Throwable> Try<V, E> success(V value) {
        return new Try<>(Objects.requireNonNull(value), null);
    }

    public static <V, E extends Throwable> Try<V, E> attempt(CheckedSupplier
                                                                     <? extends V, ? extends E> p) {
        try {
            return Try.success(p.get());
        } catch (Throwable e) {
            @SuppressWarnings("unchecked")
            E err = (E) e;
            return Try.failure(err);
        }
    }

    public <T> Try<T, E> map(Function<? super V, ? extends T> mapper) {
        return Optional.ofNullable(error)
                .map(e -> Try.<T, E>failure(e))
                .orElseGet(() -> Try.success(mapper.apply(value)));
    }

    public V orElseThrow() throws E {
        return Optional.ofNullable(value).orElseThrow(() -> error);
    }
}
