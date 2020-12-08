package com.gavin.datastructure.leetcode.middle;

import java.util.Arrays;


// 该问题比较复杂，还没理解。。。。。。


class 零钱兑换 {

    public static void main(String[] args) {
        零钱兑换 test = new 零钱兑换();
        int[] coins = {1, 2, 5};
        System.out.println(test.coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] amount) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (amount[rem - 1] != 0) {
            return amount[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, amount);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        amount[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return amount[rem - 1];
    }

}
