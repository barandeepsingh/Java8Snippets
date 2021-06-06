package com.baran.samples;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
//        int[] numbers = {5, 2, 9, 4, 11};
        int[] numbers = {5, 2, 9, 13, 11};
        sortNumbers(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sortNumbers(int[] numbers) {
        int temp;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
