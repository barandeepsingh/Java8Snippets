package com.baran.java8.leetcode.practice;

public class LongestPalindromeBruteForce {
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
        int longestCount = 1;
        String longestPalindrome = s.substring(0,1);
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                int substringLength = s.substring(j, i + 1).length();
                if (checkPalindrome(s.substring(j, i + 1)) && longestCount < substringLength) {
                    longestCount = substringLength;
                    longestPalindrome = s.substring(j, i + 1);
                }
            }
        }
        return longestPalindrome;
    }

    private boolean checkPalindrome(String s) {
        boolean result = true;
        int left = (s.length() / 2) - 1;
        int right;
        if (s.length() % 2 == 0) {
            right = (s.length() / 2);
        } else {
            right = (s.length() / 2) + 1;
        }
        while (left >= 0 && right < s.length()) {
            if (s.substring(left, left + 1).equalsIgnoreCase(s.substring(right, right + 1))) {
                left--;
                right++;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeBruteForce().longestPalindrome("babad"));
        System.out.println(new LongestPalindromeBruteForce().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromeBruteForce().longestPalindrome("a"));
        System.out.println(new LongestPalindromeBruteForce().longestPalindrome("ac"));
    }
}
