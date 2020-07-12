package com.baran.java8.samples.concurrency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        IntStream.range(1, 11).forEach(i ->
            CompletableFuture.supplyAsync(() -> getOrder(i), executorService)
                    .thenApply(CountDownLatchDemo::enrich)
                    .thenApply(CountDownLatchDemo::performPayment)
                    .thenApply(CountDownLatchDemo::dispatch)
                    .thenApply(CountDownLatchDemo::sendMail)
                    .thenApply(Order::toString)
                    .thenAccept(log::info)
                    .thenRun(() -> {
                        log.info("------------------------------------------------------------");
                        log.info("Execution completed for order {} by thread {}",i,Thread.currentThread().getName());
                        log.info("------------------------------------------------------------");
                        latch.countDown();
                    })
        );
        executorService.shutdown();
        latch.await();
        log.info("Program execution completed");


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
        pauseThread();
        log.info("Getting order for order {}",orderId);
        return new Order(orderId, "Order" + orderId, 100, false, false, false);
    }

    private static void pauseThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@AllArgsConstructor
@Data
class Order {
    private int orderId;
    private String orderName;
    private int price;
    private boolean isPaid;
    private boolean isDispatched;
    private boolean isMailSent;
}
