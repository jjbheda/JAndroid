package com.gavin.datastructure.leetcode.middle;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 */
class 乘积最大子数组 {
   public int maxProduct(int[] nums) {
      int length = nums.length;
      int[] maxF = new int[length];
      int[] minF = new int[length];
      System.arraycopy(nums, 0, maxF, 0, length);
      System.arraycopy(nums, 0, minF, 0, length);
      for (int i = 1; i < length; ++i) {
         //只所以跟nums[i] 再进行比较，是因为可能出现0值
         maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
         minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
      }
      int ans = maxF[0];
      for (int i = 1; i < length; ++i) {
         ans = Math.max(ans, maxF[i]);
      }
      return ans;
   }
}
