package com.baran.java8.samples.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class ConcurrencyService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1, 100).forEach(i -> CompletableFuture.supplyAsync(() -> getOrder(i), executorService)
                .thenApply(ConcurrencyService::enrich)
                .thenApply(ConcurrencyService::performPayment)
                .thenApply(ConcurrencyService::dispatch)
                .thenApply(ConcurrencyService::sendMail)
                .thenApply(Order::toString)
                .thenAccept(log::info)
                .thenRun(() -> log.info("Execution completed for order {} by thread {}",i,Thread.currentThread().getName()))
        );

    }

    private static Order sendMail(Order order) {
        log.info("Sent mail for " + order.getOrderName());
        order.setMailSent(true);
        return order;
    }


    private static Order dispatch(Order order) {
        log.info("Dispatched for " + order.getOrderName());
        order.setDispatched(true);
        return order;
    }

    private static Order performPayment(Order order) {
        log.info("Paid for " + order.getOrderName());
        order.setPaid(true);
        return order;
    }

    private static Order enrich(Order order) {
        log.info("Enriched for " + order.getOrderName());
        order.setPrice(order.getPrice() * 2);
        return order;
    }

    private static Order getOrder(int orderId) {
        return new Order(orderId, "Order" + orderId, 100, false, false, false);
    }
}

