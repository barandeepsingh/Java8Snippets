package com.baran.java8.samples.generics.generics;

public class GenericsDemo {
    public static void main(String[] args) {
        GenericNumericOperations<Integer,Integer> genericNumericOperations = new GenericNumericOperations<>(10,20);
        System.out.println(genericNumericOperations.square());
        System.out.println(genericNumericOperations.product());
        
    }
}

class GenericNumericOperations<T extends Number,R extends Number> {
    T num1;
    R num2;


    GenericNumericOperations(T num1,R num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int square() {
        return num1.intValue()*2;
    }
    public int product() {
        return num1.intValue()*num2.intValue();
    }


}


