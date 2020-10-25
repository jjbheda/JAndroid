package com.gavin.datastructure.leetcode;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 青蛙跳台阶 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.printf(numWays(50) + "");
    }


    // 递归法
    public static int numWays(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
        }
    }


    // 动态规划
    public int numWays2(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;    // > 1000000007,先减去1000000007 再计算，相当于取模
            a = b;
            b = sum;
        }
        return a;
    }
}

