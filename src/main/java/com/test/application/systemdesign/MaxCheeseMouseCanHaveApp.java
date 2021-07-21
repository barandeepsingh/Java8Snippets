package com.test.application.systemdesign;

import javafx.util.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxCheeseMouseCanHaveApp {

    public static void main(String[] args) {
        /*
         * Scanner sc = new Scanner(System.in); int t = sc.nextInt(); int[][] result =
         * new int[t][]; for (int i = 0; i < t; i++) { int n = sc.nextInt(); int[] arr =
         * new int[n]; for (int j = 0; j < n; j++) { arr[j]=sc.nextInt(); }
         * result[i]=arr; } sc.close(); for (int i = 0; i < t; i++) {
         * System.out.println(maxCheezeMouseCanHave(result[i])); }
         */
        int[] arr = {9, 118, 202, 104, 10};
        System.out.println(maxCheeseMouseCanHave(arr));
    }

    private static long maxCheeseMouseCanHave(int[] arr) {
        AtomicInteger max = getMax(arr);
        System.out.println(max.get());

        List<Integer> indexes = findMaxIndices(arr, max);
        System.out.println(indexes);

        for (Integer maxIndex : indexes) {
            Pair<int[], int[]> leftRightSubArrays = getLeftRightSubArrays(arr, maxIndex);
            System.out.println("left:" + Arrays.toString(leftRightSubArrays.getKey()));
            System.out.println("right:" + Arrays.toString(leftRightSubArrays.getValue()));
            /*
             * if(maxIndex-1>=0) { int left=maxIndex-1;
             * System.out.println("left:"+left+"element:"+arr[left]);
             *
             * } if(maxIndex+1<arrLength) { int right = maxIndex+1;
             * System.out.println("right:"+right+"element:"+arr[right]); }
             */
        }

        return 0;
    }

    private static Pair<int[], int[]> getLeftRightSubArrays(int[] arr, int cutIndex) {
        int arrLength = arr.length;
        int[] leftMaxArr = null;
        int[] rightMaxArr = null;
        if (cutIndex - 2 >= 0) {
            leftMaxArr = Arrays.copyOfRange(arr, 0, cutIndex - 1);
        }
        if (cutIndex + 2 < arrLength) {
            rightMaxArr = Arrays.copyOfRange(arr, cutIndex + 2, arrLength);
        }
        return new Pair<>(leftMaxArr, rightMaxArr);
    }

    private static List<Integer> findMaxIndices(int[] arr, AtomicInteger max) {
        List<Integer> indexes = IntStream.range(0, arr.length)
                .filter(i -> arr[i] == max.get())
                .boxed()
                .collect(Collectors.toList());
        return indexes;
    }

    private static int getFrequency(int[] arr, AtomicInteger max) {
        return Collections.frequency(Arrays.stream(arr).boxed().collect(Collectors.toList()), max.get());
    }

    private static AtomicInteger getMax(int[] arr) {
        AtomicInteger max = new AtomicInteger();
        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .findFirst().ifPresent(max::set);
        return max;
    }

}
/**
 * 2
 * 6
 * 8 5 10 100 10 5
 * 3
 * 1 2 3
 */

