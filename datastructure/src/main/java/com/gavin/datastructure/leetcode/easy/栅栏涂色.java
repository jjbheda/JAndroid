package com.gavin.datastructure.leetcode.easy;

/**
 * 题目描述
 * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 *
 * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。
 *
 * 注意:
 * n 和 k 均为非负的整数。
 *
 * 示例:
 *
 * 输入: n = 3，k = 2
 * 输出: 6
 *
 * 定义状态，用f[i]表示从左到有走到下标为i的栅栏时的涂色总数，显然f[0] = k， f[1] = k * k，f[2] = k * k * k - k
 *
 * 状态迁移方程：
 *
 * 分成两种情况来思考：
 *
 * 当前栅栏颜色和前一个颜色相同，则表示更前一个栅栏颜色和右边两个不同，到更前一个栅栏的涂色方案有f(i-2)种，后面两个涂色相同，共k-1种
 * 当前栅栏颜色和前一个不同，则当前栅栏涂色方案有k-1种，到前一个栅栏为止，涂色方案有f(i-1)种
 * 所以递推公式是：f[i] = (k - 1) * f[i-1] + (k - 1) * f[i-2]
 */
class 栅栏涂色 {

    public static void main(String[] args) {
        System.out.println(numWays(3,2));
    }

   public static int numWays( int n , int k) {
        if(k == 0 || n == 0) {
            return 0;
       }
        if (n < 2) {
            return k;
        }

        int[] dp = new int[n];
        dp[0] = k;

        dp[1] = k * k;

        for (int i = 2; i < n ; i++) {
            dp[i] = (dp[i -1] + dp[i -2]) * (k - 1);
        }

        return dp[n - 1];
   }
}
