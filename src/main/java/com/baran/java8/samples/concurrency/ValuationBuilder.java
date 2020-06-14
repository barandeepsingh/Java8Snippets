package com.baran.java8.samples.concurrency;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class ValuationBuilder implements Callable<Stream<String>> {
    private String assetClass;
    private String fileName;
    private int batchSize;
    private int minCacheId;
    private int maxCacheId;
    private String jurisdiction;

    private ValuationBuilder(int batchSize, int minCacheId, int maxCacheId) {
        this.batchSize = batchSize;
        this.minCacheId = minCacheId;
        this.maxCacheId = maxCacheId;
    }

    public static ValuationBuilder create(int batchSize, int minCacheId, int maxCacheId) {
        return new ValuationBuilder(batchSize, minCacheId, maxCacheId);
    }

    public ValuationBuilder assetClass(String assetClass) {
        this.assetClass = assetClass;
        return this;
    }

    public ValuationBuilder jurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
        return this;
    }

    @Override
    public Stream<String> call() throws Exception {
        System.out.println("Inside thread "+Thread.currentThread().getName());
        if (assetClass.equalsIgnoreCase("Credit")) {
            Thread.sleep(5000);
        } else {
            Thread.sleep(2000);
        }

        return getStream();
    }

    private Stream<String> getStream(){
        return Stream.of("Name1-"+assetClass+"-"+jurisdiction, "Name2-"+assetClass+"-"+jurisdiction, "Name3-"+assetClass+"-"+jurisdiction, "Name4-"+assetClass+"-"+jurisdiction);
    }

}
