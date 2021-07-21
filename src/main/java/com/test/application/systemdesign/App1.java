package com.test.application.systemdesign;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class App1 {
    public static void main(String[] args) {
        int[] intArr = {5, 6, 3, 4, 8, 9, 11};
        //sum of even numbers
        System.out.println("Sum of even numbers is " + totalValues(intArr, num -> num % 2 == 0));
        //sum of odd numbers
        System.out.println("Sum of even numbers is " + totalValues(intArr, num -> num % 2 != 0));
        //sum of numbers
        System.out.println("Sum of numbers is " + genericMathOperation(intArr, Objects::nonNull, 0, Integer::sum));
        //product
        System.out.println("Product of even numbers is " + genericMathOperation(intArr, num -> num % 2 == 0, 1, (a, b) -> a * b));
    }

    private static int totalValues(int[] values, IntPredicate selector) {
        return Arrays.stream(values)
                .filter(selector)
                .sum();
    }

    private static int genericMathOperation(int[] values, IntPredicate selector, int identityValue, IntBinaryOperator transformationFunction) {
        return Arrays.stream(values)
                .filter(selector)
                .reduce(identityValue, transformationFunction);
    }

}
