package com.baran.java8.samples.monads.custom;

import java.io.File;
import java.io.FileInputStream;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TryMonadTestCases {

    private static final BiFunction<Integer, Integer, Try<Integer>> trySum =
            (a, b) -> Try.of(() -> a + b);

    private static final BiFunction<Integer, Integer, Try<Integer>> tryDivision =
            (a, b) -> Try.of(() -> a / b);

    private static final Supplier<Try<Integer>> mapSample = () ->
            Try.of(() -> 5 + 6)
                    .filter(e -> e % 2 != 0)
                    .map(e -> e * 2);

    private static final Procedure trySumPositiveTestCase = () ->
            trySum.apply(5, 6)
                    .onSuccess(result ->
                            System.out.println("Do whatever you want to do with the sum value.Write a lambda.Value of sum is " + result))
                    .onFailure(ex ->
                            System.err.println("This is error path" + ex.getMessage()))
                    .orElse(0);//This can be used to provide a default value in case success path fails.


    private static final Procedure happyPathDivision = () -> //Happy path sample
            tryDivision.apply(10, 5)
                    .onSuccess(result -> System.out.println("Value of div is " + result))
                    .onFailure(ex -> System.err.println("This is error path" + ex.getMessage()))
                    .orElse(0);//This can be used to provide a default value in case success path fails.


    private static final Procedure nonHappyPathDivision = () ->
            //Non-happy path sample
            tryDivision.apply(3, 0)
                    .onSuccess(result ->
                            System.out.println("Value of div is " + result))
                    .onFailure(ex ->
                            System.err.println("This is error path " + ex.getMessage()))
                    .orElse(10);//This can be used to provide a default value in case success path fails.

    private static final Procedure mapSampleDemo = () ->
            mapSample.get()
                    .onSuccess(e -> System.out.println("mapSampleDemo is " + e))
                    .onFailure(ex -> System.err.println("mapSampleDemo exception " + ex.getMessage()));


    private static final Supplier<Try<FileInputStream>> checkedExceptionWithTryMonad = () ->
            Try.of(() ->
//                    new FileInputStream(new File("not_existing_file.txt")));
                    new FileInputStream(new File("build.gradle")));


    private static final Function<FileInputStream, Try<Character>> getCharacter = fileInputStream ->
//            Try.of(() -> (char) fileInputStream.read());
            Try.failure(new RuntimeException("Failed badly"));

    private static final Consumer<FileInputStream> getCharacterForFileInputStream = fileInputStream ->
        getCharacter.apply(fileInputStream)
                .onSuccess(System.out::println)
                .onFailure(System.err::println)
                .orElseTry(()-> {
                    System.out.println("Recovering using else try");
                    return 'a';
                }).getUnchecked();

    private static final Procedure demoPowerOfTryMonadForCheckedExceptions = () ->
            checkedExceptionWithTryMonad.get()
                    .onSuccess(getCharacterForFileInputStream::accept)
                    .onFailure(ex -> System.err.println(ex.getMessage()));

    public static void main(String[] args) throws Throwable {
        trySumPositiveTestCase.invoke();
        happyPathDivision.invoke();
        nonHappyPathDivision.invoke();
        mapSampleDemo.invoke();
        demoPowerOfTryMonadForCheckedExceptions.invoke();
    }

}
