package com.test.application.systemdesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxCheeze {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(8, 5, 10, 100, 10, 5));
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(9, 118, 202, 104, 10));
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> integerList = new ArrayList<>(Arrays.asList(7, 108, 102, 6, 103, 4, 101));
        recursiveCall(integerList, 0);
        System.out.println("Sum:" + maxSum);


    }

    private static void recursiveCall(List<Integer> subList, int count) {
        if (subList.isEmpty()) {
            if (maxSum < count)
                maxSum = count;
        } else {
            System.out.println(subList);
            System.out.println("count:" + count);
            if (subList.size() == 2) {
                count += Math.max(subList.get(0), subList.get(1));
                recursiveCall(Collections.emptyList(), count);

            }
            if (subList.size() == 1) {
                recursiveCall(Collections.emptyList(), count + subList.get(0));
            }
            if (subList.size() > 2) {
                List<Integer> subSubList1 = subList.subList(2, subList.size());
                recursiveCall(subSubList1, count + subList.get(0));

                List<Integer> subSubList2 = subList.subList(3, subList.size());
                recursiveCall(subSubList2, count + subList.get(1));
            }
        }
    }
}
