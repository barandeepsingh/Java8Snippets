package com.baran.java8.samples.custom.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> multiplyThreeValues = (num1, num2, num3) -> {
            return num1 * num2 * num3;
        };
        TriFunction<String, Integer, Integer, String> concatItems = (str, num1, num2) -> {
            return String.format("Map result is %1$s %2$d %3$d",str,num1,num2);
        };
        Procedure multiplyThreeProcedure = () -> {
            int num1 = 10;
            int num2 = 13;
            int num3 = 11;
            System.out.println("Product is " + multiplyThreeValues.apply(num1, num2, num3));

            List<String> stringAL = new ArrayList<>();
            stringAL.add("a1");
            stringAL.add("a3");
            stringAL.add("a4");

            stringAL.stream().map(item->concatItems.apply(item,10,15)).forEach(System.out::println);
        };


        multiplyThreeProcedure.invoke();


    }
}
