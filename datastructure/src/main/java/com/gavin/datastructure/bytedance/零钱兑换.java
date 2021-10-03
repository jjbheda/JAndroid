package com.gavin.datastructure.bytedance;

import java.util.Arrays;

class 零钱兑换 {


    /**
     * 首先，我们先来思考一些基本的情况：如果a m o u n t < 0 amount<0amount<0，那么结果就是-1；如果a m o u n t = 0 amount=0amount=0，结果自然是0。但如果amount不是前面这两种特殊的值，那么就需要从给定的k种面值的硬币中找到满足题目要求的组合。假设给定的a m o u n t = n amount=namount=n，对于可选择面值的列表中的每一种面值m，我们可以做的选择是选还是不选：
     *
     * 如果选，那么看a m o u n t − m amount - mamount−m有没有相应的最优解r。如果有，那么a m o u n t = n amount=namount=n的最优解自然就是r + 1 r + 1r+1。因为，在a m o u n t − m amount - mamount−m最优解的前提下，只需要再多取一枚面值为m的硬币即可
     * 如果不选，则继续判断下一个可能面值的硬币
     * 遍历所有可能的面值，然后从所有可能的结果r i r_{i}r
     * i
     * ​
     *  中找到值最小那个，它就是a m o u n t = n amount=namount=n的最优解。因此，总结上面思考的过程可写出动态转移方程：
     *
     * ​
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        零钱兑换 test = new 零钱兑换();
        System.out.println(test.coinChange(coins, amount));
    }

    /**
     *
     * @param coins
     * @param amount   币值总和
     *
     * @return
     */
    private int coinChange( int[] coins, int amount) {
        //dp[i]表示钱数为i时最小硬币数
        int dp[] = new int[amount + 1];
        //初始化钱数为i时的硬币数
        Arrays.fill(dp,amount +1);
        dp[0] = 0; //钱数为0时的最小硬币数也为0

        //dp--》 【0，12，12，12...12】

        for(int i = 0; i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]> amount ? -1:dp[amount];
    }
}
