package com.test;

import java.util.Deque;
import java.util.LinkedList;

public class SampleBracketsApp {
    public static void main(String[] args) {

        System.out.println(getResult("{([])}"));
        System.out.println(getResult("()"));
        System.out.println(getResult("([]"));
    }

    private static boolean getResult(String str) {


        Deque<Character> bracketDeque = new LinkedList<>();
        for (char ch: str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                bracketDeque.addFirst(ch);
            } else {
                if (!bracketDeque.isEmpty()
                        && ((bracketDeque.peekFirst() == '{' && ch == '}')
                        || (bracketDeque.peekFirst() == '[' && ch == ']')
                        || (bracketDeque.peekFirst() == '(' && ch == ')'))) {
                    bracketDeque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}

