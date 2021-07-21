package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MaximumCheezeMouseCanHave {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {


        // for taking count of test-cases
        System.out.println("Please enter the number of test cases");
        int T = getIntInput();
        if (!(T >= 1 && T <= 200)) {
            throw new CheezeProblemInputDataMismatchException("T value should be between 1 and 200 both inclusive");
        }

        // for storing the input array for each test-case
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            System.out.println("Please enter the number of elements to include in the test case");
            int n = getIntInput();
            if (!(n >= 1 && n <= 1000)) {
                throw new CheezeProblemInputDataMismatchException("Value of n is expected between 1 and 1000 both inclusive");
            }
            a.add(getTestCaseArrayFromInput(n));

        }
        // calculating the max cheeze that mouse can have for each test-case one by one
        for (int i = 0; i < T; i++) {
            maxSum = Integer.MIN_VALUE;
            maxCheezeMouseCanHave(a.get(i), 0);
            System.out.println(maxSum);
        }

    }


    private static int getIntInput() {
        //Assuming user will input only integer when required else will throw number format exception
        return Integer.parseInt(getInput());
    }

    private static String getInput() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while (true) {
            try {
                if ((line = r.readLine()) != null) return line;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int[] getTestCaseArrayFromInput(int size) {
        System.out.println("Enter test array elements ");
        String[] inputArrStr = getInput().split("\\s");
        System.out.println(Arrays.toString(inputArrStr));
        //Assuming user will not input items other than integer
        // else will result in NumberFormatException
        int[] inputArr = Stream.of(inputArrStr)
                .mapToInt(Integer::parseInt)
                .filter(e -> 1 <= e && e <= 10000)
                .toArray();

        if (inputArrStr.length != size) {
            throw new CheezeProblemInputDataMismatchException("Size of array does not match the expected size for this input.");
        } else if (inputArr.length != inputArrStr.length) {
            throw new CheezeProblemInputDataMismatchException("Some inputs have been filtered out as they could not meet filter conditions.");
        }
        return inputArr;

    }

    private static void maxCheezeMouseCanHave(int[] subList, int count) {
        // if arr is null or empty , then updating the current max weight count if it is
        // less than maxSum i.e already calculated sum considering different options
        if (subList == null || subList.length == 0) {
            if (maxSum < count)
                maxSum = count;
        } else {
            // if sub-array size becomes 2 , choosing the max from available 2 options
            if (subList.length == 2) {
                count += Math.max(subList[0], subList[1]);
                maxCheezeMouseCanHave(null, count);
            } else if (subList.length == 1) { // if sub-array size becomes 1, choose
                count += subList[0];
                maxCheezeMouseCanHave(null, count);
            } else {
                // dividing arr to sub-array considering 0th index as 1st option and recursively
                // calling it till there is 0 element left in the sub-array
                int[] subSubList = Arrays.copyOfRange(subList, 2, subList.length);
                maxCheezeMouseCanHave(subSubList, count + subList[0]);

                // dividing arr to sub-array considering 1st index as 1st option and recursively
                // calling it till there is 0 element left in the sub-array
                int[] subList2 = Arrays.copyOfRange(subList, 3, subList.length);
                maxCheezeMouseCanHave(subList2, count + subList[1]);
            }
        }
    }

}
