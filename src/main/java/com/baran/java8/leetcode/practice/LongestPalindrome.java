package com.baran.java8.leetcode.practice;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String result = null;
        if (s.length() == 1) {
            result = s;
        } else {
            result = getLongestPalindrome(s);
        }
        return result;
    }

    private String getLongestPalindrome(String s) {
        AtomicInteger longestCount = new AtomicInteger(1);
        AtomicReference<String> longestPalindrome = new AtomicReference<>(s.substring(0, 1));
        for (int i = 0; i < s.length(); i++) {
            getLargestPalindrome(s, i, i)
                    .filter(palindrome -> palindrome.length() > longestCount.get())
                    .ifPresent(palindrome -> {
                        longestPalindrome.set(palindrome);
                        longestCount.set(palindrome.length());
                    });

            getLargestPalindrome(s, i, i + 1)
                    .filter(palindrome -> palindrome.length() > longestCount.get())
                    .ifPresent(palindrome -> {
                        longestPalindrome.set(palindrome);
                        longestCount.set(palindrome.length());
                    });
        }
        return longestPalindrome.get();
    }

    private Optional<String> getLargestPalindrome(String s, int left, int right) {
        String largestPalindrome = null;
        while (left >= 0 && right < s.length() && left <= right && s.charAt(left) == s.charAt(right)) {
            largestPalindrome = s.substring(left, right + 1);
            left--;
            right++;
        }
        return Optional.ofNullable(largestPalindrome);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abb"));
//        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
//        System.out.println(new LongestPalindrome().longestPalindrome("bb"));
//        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
//        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
//        System.out.println(new LongestPalindrome().longestPalindrome("a"));
//        System.out.println(new LongestPalindrome().longestPalindrome("ac"));
//        System.out.println(new LongestPalindrome().longestPalindrome("abb"));
    }
}
