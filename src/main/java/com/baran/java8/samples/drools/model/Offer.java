package com.baran.java8.samples.drools.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Offer {
    private ProductPackage financialPackage;
    private List<Product> products = new ArrayList();
    private int discount;
    private int xPathResponse;

    public void addSingleProduct(Product prod) {
        products.add(prod);
    }


    public enum Product {
        LOAN,
        SUPERLOAN,
        INSURANCE
    }

    public enum ProductPackage {
        GETTINGSTARTED_PACKAGE,
        CAREERFOCUSED_PACKAGE,
        ADVICEFAMILY_PACKAGE,
        EMPTYNESTER_PACKAGE,
        GOLDENYEARS_PACKAGE,
        BUSINESS_PACKAGE
    }
}
