package com.baran.java8.samples.custom.functionalinterfaces;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> multiplyThreeValues = (num1, num2, num3) -> {
            return num1 * num2 * num3;
        };

        Procedure multiplyThreeProcedure = () -> {
            int num1 = 10;
            int num2 = 13;
            int num3 = 11;
            System.out.println("Product is " + multiplyThreeValues.apply(num1, num2, num3));
        };

        multiplyThreeProcedure.invoke();


    }
}
