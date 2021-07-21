package com.test;
//Longest Increasing Subsequence
//        0    1    2   4  5
//        Input: arr[] = {3, 10, 2, 1, 20}    // 3->3
//        Output: Length of LIS = 3
//        The longest increasing subsequence is 3, 10, 20
//
//        Input: arr[] = {3, 2}
//        Output: Length of LIS = 1
//        The longest increasing subsequences are {3} and {2}
//
//        Input: arr[] = {50, 3, 10, 7, 40, 80}
//        Output: Length of LIS = 4
//        The longest increasing subsequence is {3, 7, 40, 80}
//

public class LongestIncreasingSubsequenceApp {
    public static void main(String[] args) {
        int arr1[] = {3, 10, 2, 1, 20};
        int arr2[] = {3, 2};
        int arr3[] = {50, 3, 10, 7, 40, 80};
        System.out.println("Length of LIS is "+getLongestIncreasingSubsequence(arr1));
        System.out.println("Length of LIS is "+getLongestIncreasingSubsequence(arr2));
        System.out.println("Length of LIS is "+getLongestIncreasingSubsequence(arr3));

    }

    private static int getLongestIncreasingSubsequence(int arr[]) {
        int innerCounter = 0;
        int mainCounter = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
//                System.out.println("arr[j] and arr[i]"+arr[j] +"-"+ arr[i]);
                if (arr[j] > arr[i]) {
//                    System.out.println("inner counter increment ");
                    innerCounter++;
                }
            }
//            System.out.println("innerCounter "+innerCounter);
//            System.out.println("mainCounter "+mainCounter);
            if (innerCounter > mainCounter) {
                mainCounter = innerCounter;
            }
            innerCounter=0;
        }
        return mainCounter+1;
    }

}
