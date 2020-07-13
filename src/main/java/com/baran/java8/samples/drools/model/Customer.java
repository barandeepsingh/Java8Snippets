package com.baran.java8.samples.drools.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Customer {
    private CustomerLifeStage lifeStage;
    private CustomerAssets assets;
    private List<CustomerNeed> customerNeeds = new ArrayList<>();
    private List<String> xPaths;
    public void addNeed(CustomerNeed need) {
        customerNeeds.add(need);
    }

    public enum CustomerNeed {
        SAVINGACCOUNT,
        LIFEINSURANCE,
        DIGITALBANKING,
        STUDENTLOAN,
        MORTAGE
    }

    public enum CustomerLifeStage {
        GETTINGSTARTED,
        CAREERFOCUSED,
        ADVICEFAMILY,
        EMPTYNESTER,
        GOLDENYEARS,
        BUSINESS
    }

    public enum CustomerAssets {
        TO50K,
        FROM50KTO150K,
        FROM150KTO300K,
        OVER300K
    }
}
