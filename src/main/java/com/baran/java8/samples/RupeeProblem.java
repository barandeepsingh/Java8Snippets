package com.baran.java8.samples;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RupeeProblem {
    private final int rupeeValue = 29;
    private int rupee1CountInitial = 3, rupee2CountInitial = 2, rupee5CountInitial = 1;

    public static void main(String[] args) {
        RupeeProblem rupeeProblem = new RupeeProblem();
        log.info("Total combinations are {}", rupeeProblem.validateRupeeValue());
    }

    private int validateRupeeValue() {
        int minValue = 12;
        if (rupeeValue < minValue) {
            return 0;
        } else if (rupeeValue == minValue) {
            return 1;
        } else {
            int remainingValue = rupeeValue - minValue;
            Pair<Integer, Integer> divideBy5Pair = divideByNumber(remainingValue, 5);
            int remaining5Count = divideBy5Pair.getKey();
            Pair<Integer, Integer> divideBy2Pair = divideByNumber(divideBy5Pair.getValue(), 2);
            int remaining2Count = divideBy2Pair.getKey();
            int remaining1Count = divideBy2Pair.getValue();
            int rupee1CountFinal = rupee1CountInitial + remaining1Count;
            int rupee2CountFinal = rupee2CountInitial + remaining2Count;
            int rupee5CountFinal = rupee5CountInitial + remaining5Count;
            return generateCombinationsForCoins(rupee1CountFinal, rupee2CountFinal, rupee5CountFinal);
        }
    }

    private Pair<Integer, Integer> divideByNumber(final int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new Pair<>(quotient, remainder);
    }

    private int generateCombinationsForCoins(final int rupee1CountFinal, final int rupee2CountFinal, final int rupee5CountFinal) {
        int totalCombinations = 0;
        totalCombinations = validateCase(rupee1CountFinal, rupee2CountFinal, rupee5CountFinal) ? totalCombinations + 1 : totalCombinations;
        totalCombinations = totalCombinations + split(rupee1CountFinal, rupee2CountFinal, rupee5CountFinal);
        return totalCombinations;
    }

    private int split(int rupee1CountFinal, int rupee2CountFinal, int rupee5CountFinal) {
        int counter = 0;
        log.info("Inside split5 : {},{},{}" ,rupee1CountFinal,rupee2CountFinal,rupee5CountFinal);
        if (rupee5CountFinal > 1) {
            counter = validateCase(rupee1CountFinal + 1, rupee2CountFinal + 2, rupee5CountFinal - 1) ?
                    counter + 1 + split(rupee1CountFinal + 1, rupee2CountFinal + 2, rupee5CountFinal - 1) : counter;
            counter = validateCase(rupee1CountFinal + 3, rupee2CountFinal + 1, rupee5CountFinal - 1) ?
                    counter + 1 + split(rupee1CountFinal + 3, rupee2CountFinal + 1, rupee5CountFinal - 1) : counter;
            counter = validateCase(rupee1CountFinal + 5, rupee2CountFinal, rupee5CountFinal - 1) ?
                    counter + 1 + split(rupee1CountFinal + 5, rupee2CountFinal, rupee5CountFinal - 1) : counter;
            if(rupee2CountFinal>2) {
                counter = validateCase(rupee1CountFinal + 2, rupee2CountFinal - 1, rupee5CountFinal) ?
                        counter + 1 + split(rupee1CountFinal + 2, rupee2CountFinal - 1, rupee5CountFinal) : counter;
            }
        }
        return counter;
    }



    private boolean validateCase(int rupee1Count, int rupee2Count, int rupee5Count) {
        boolean result = rupee1Count > rupee2Count && rupee2Count > rupee5Count && (rupee1Count * 1 + rupee2Count * 2 + rupee5Count * 5 == rupeeValue);
        log.info("Rs.1 {} , Rs.2 {}, Rs.5 {} and result is {}", rupee1Count, rupee2Count, rupee5Count, result);
        return result;
    }
}
