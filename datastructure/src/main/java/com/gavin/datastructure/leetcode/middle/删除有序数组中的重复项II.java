package com.gavin.datastructure.leetcode.middle;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 因为给定数组是有序的，所以相同元素必然连续。我们可以使用双指针解决本题，遍历数组检查每一个元素是否应该被保留，如果应该被保留，就将其移动到指定位置。具体地，我们定义两个指针 slow 和 fast 分别为慢指针和快指针，其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度，即 nums[fast]表示待检查的第一个元素，nums[slow−1]为上一个应该被保留的元素所移动到的指定位置。
 *
 * 因为本题要求相同元素最多出现两次而非一次，所以我们需要检查上上个应该被保留的元素 nums[slow−2]是否和当前待检查元素 nums[fast]相同。当且仅当 nums[slow−2]=nums[fast]时，当前待检查元素 nums[fast]不应该被保留（因为此时必然有 nums[slow−2]=nums[slow−1]=nums[fast]）。最后，slow即为处理好的数组的长度。
 *
 */
class 删除有序数组中的重复项II {

   public static int[] nums = new int[]{1,1,1,2,2,3};

   public static void main(String[] args) {
      removeDuplicates(nums);

   }

   public static int removeDuplicates(int[] nums) {
      int n = nums.length;
      if (n <= 2) {
         return n;
      }

      int slow = 2, fast = 2;
      while (fast < n) {
         if (nums[slow - 2] != nums[fast]) {
            nums[slow] = nums[fast];
            ++slow;
         }
         ++fast;

      }

      for (int i=0;i <slow;i++) {
         System.out.println(nums[i]);
      }
      return slow;
   }

}
