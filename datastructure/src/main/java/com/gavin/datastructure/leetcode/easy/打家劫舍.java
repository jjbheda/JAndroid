package com.gavin.datastructure.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class 打家劫舍 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,5,7};
        System.out.println(rob(nums));
    }


    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

}
