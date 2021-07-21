package com.baran.java8.leetcode.practice;

public class PalindromicSubstring {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        } else if (s.length() < 2) {
            return s.length();
        }
        return getLongestPalindrome(s);
    }

    private int getLongestPalindrome(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            totalCount += expandFromMiddle(s, i, i);
            totalCount += expandFromMiddle(s, i, i + 1);
        }
        return totalCount;
    }

    private int expandFromMiddle(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && left <= right && s.charAt(left) == s.charAt(right)) {
//            System.out.println("Pal " + s.substring(left, right + 1));
            result++;
            left--;
            right++;
        }
//        System.out.println("Result is " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstring().countSubstrings("aaa"));
        System.out.println(new PalindromicSubstring().countSubstrings("abc"));
    }
}
