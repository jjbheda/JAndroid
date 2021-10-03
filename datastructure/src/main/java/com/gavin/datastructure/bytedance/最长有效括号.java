package com.gavin.datastructure.bytedance;

import java.util.Deque;
import java.util.LinkedList;

class 最长有效括号 {

    public static void main(String[] args) {
        最长有效括号 test = new 最长有效括号();
        test.longestValidParentheses(")()())");
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
