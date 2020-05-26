package com.baran.java8.samples;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalIfElse {
    public static void main(String[] args) {

        Product product1 = new Product(1, "Audi A8");
        String category1 = "car";
        System.out.println(ProductProxy.getEnrichedProduct.apply(product1, category1).toString());

        Product product2 = new Product(2, "OnePlus 8 Pro");
        String category2 = "mobile";
        System.out.println(ProductProxy.getEnrichedProduct.apply(product2, category2).toString());

        Product product3 = new Product(3, "Macbook Pro");
        String category3 = "laptop";
        System.out.println(ProductProxy.getEnrichedProduct.apply(product3, category3).toString());

        Product product4 = new Product(4, "Emaar Palm Heights");
        String category4 = "home";
        System.out.println(ProductProxy.getEnrichedProduct.apply(product4, category4).toString());


    }

}

@AllArgsConstructor
@Data
class Product {
    private int productId;
    private String productName;
}

class ProductProxy {
    static BiFunction<Product, String, Product> getEnrichedProduct = (inputProduct, category) -> {
        AtomicReference<Product> outputProduct = new AtomicReference<>();
        Objects.requireNonNull(category, "The category is null");

        Predicate<String> checkIsCar = productCategory -> productCategory.equalsIgnoreCase("car") ? true : false;
        Predicate<String> checkIsMobile = productCategory -> productCategory.equalsIgnoreCase("mobile") ? true : false;
        Predicate<String> checkIsLaptop = productCategory -> productCategory.equalsIgnoreCase("laptop") ? true : false;

        Optional.ofNullable(category).filter(checkIsCar).map(input -> ProductService.enrichProductForCar.apply(inputProduct)).map(Optional::of).ifPresent(returnedProduct -> outputProduct.set(returnedProduct.get()));
        Optional.ofNullable(category).filter(checkIsMobile).map(input -> ProductService.enrichProductForMobile.apply(inputProduct)).map(Optional::of).ifPresent(returnedProduct -> outputProduct.set(returnedProduct.get()));
        Optional.ofNullable(category).filter(checkIsLaptop).map(input -> ProductService.enrichProductForLaptop.apply(inputProduct)).map(Optional::of).ifPresent(returnedProduct -> outputProduct.set(returnedProduct.get()));

        Optional.ofNullable(outputProduct.get()).orElseThrow(() -> new RuntimeException("This is not a valid category"));

        return outputProduct.get();
    };

}

class ProductService {
    static Function<Product, Product> enrichProductForCar = inputProduct -> {
        inputProduct.setProductName(inputProduct.getProductName() + ":Car");
        return inputProduct;
    };
    static Function<Product, Product> enrichProductForMobile = inputProduct -> {
        inputProduct.setProductName(inputProduct.getProductName() + ":Mobile");
        return inputProduct;
    };
    static Function<Product, Product> enrichProductForLaptop = inputProduct -> {
        inputProduct.setProductName(inputProduct.getProductName() + ":Laptop");
        return inputProduct;
    };
}


