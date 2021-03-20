package com.baran.java8.samples.monads.custom;

public class TryMonadTestCases {
    public static Try<Integer> trySum() {
        return Try.of(() -> 5 + 6);
    }

    public static Try<Integer> tryDivision(final int a, final int b) {
        return Try.of(() -> a / b);
    }

    public static void main(String[] args) throws Throwable {
        trySum()
                .onSuccess(result -> {
                    System.out.println("Do whatever you want to do with the sum value.Write a lambda.");
                    System.out.println("Value of sum is " + result);
                })
                .onFailure(ex -> {
                    System.err.println("This is error path");
                    System.err.println("Print exception here or do something else.");
                })
                .orElse(0);//This can be used to provide a default value in case success path fails.

//Happy path
        tryDivision(10, 5)
                .onSuccess(result -> {
                    System.out.println("Value of div is " + result);
                })
                .onFailure(ex -> {
                    System.err.println("This is error path");
                    System.err.println(ex.getMessage());
                })
                .orElse(0);//This can be used to provide a default value in case success path fails.


//Non-happy path
        tryDivision(3, 0)
                .onSuccess(result -> {
                    System.out.println("Value of div is " + result);
                })
                .onFailure(ex -> {
                    System.err.println("This is error path");
                    System.err.println(ex);
                })
                .orElse(10);//This can be used to provide a default value in case success path fails.

    }

}
