package com.baran.java8.samples.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcurrencyService {
    private static List<String> assetClassesList = Arrays.asList("FX", "Credit", "Equity", "InterestRate");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        assetClassesList.stream().forEach(assetClass -> {
            ValuationBuilder valuationBuilder = ValuationBuilder.create(5000, 10, 20000).assetClass(assetClass).jurisdiction("KRX");
            Future<Stream<String>> futureItem = executorService.submit(valuationBuilder);
            try {
                futureItem.get().forEach(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


        });
        executorService.shutdown();


/*

        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Callable<String>> callables = Arrays.asList(
                () -> "t1",
                () -> "t2"
        );

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

*/


    }


}
