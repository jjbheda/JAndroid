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

        if (nums == null && nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i ++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;

    }

}
