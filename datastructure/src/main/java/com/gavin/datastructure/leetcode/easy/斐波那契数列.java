package com.gavin.datastructure.leetcode.easy;

class 斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int pre = 0;
        int cur = 1;

        for (int i = 2; i <= n; i ++) {
            int temp = (pre + cur) % 1000000001;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
