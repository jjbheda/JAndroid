package com.gavin.datastructure.bytedance;

import java.util.Stack;

class Test2 {

    public int JumpFloor(int target) {
        if (target == 0 || target == 1) {
            return 0;
        }

        int[] dp = new int[1000];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int min = Math.min(0,1);
        return dp[target - 1];


    }
}
