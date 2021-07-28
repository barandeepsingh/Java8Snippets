package com.baran.java8.samples.bitwise;

public class BitWiseOperations {
    public static void main(String[] args) {
        xorOperator(2, 3);
        swapNumbers(2, 3);
        divideByTwo(new int[]{10, 20, 30, 16, 4});
        multiplyByTwo(new int[]{10, 20, 30, 16, 4});
    }

    private static void multiplyByTwo(int[] ints) {
        System.out.println("multiplyByTwo");
        for (int anInt : ints) {
            System.out.print(anInt << 1);
            System.out.print("-");
        }
        System.out.println();
    }

    private static void divideByTwo(int[] ints) {
        System.out.println("divideByTwo");
        for (int anInt : ints) {
            System.out.print(anInt >> 1);
            System.out.print("-");
        }
        System.out.println();
    }

    private static void swapNumbers(int i, int j) {
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
        System.out.println("i:" + i + "-" + "j:" + j);
    }

    private static void xorOperator(int a, int b) {
        System.out.println("a ^ b : " + (a ^ b));
        System.out.println("a ^ 0 = a " + (a ^ 0));
        System.out.println("a ^ 1 : " + (a ^ 1));
    }
}
