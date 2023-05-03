package com.gavin.datastructure.leetcode.easy;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
class 移除元素 {

   /**
    * 方法1
    * 方法一：双指针
    * 思路及算法
    *
    * 由于题目要求删除数组中等于 val\textit{val}val 的元素，因此输出数组的长度一定小于等于输入数组的长度，我们可以把输出的数组直接写在输入数组上。可以使用双指针：右指针 right\textit{right}right 指向当前将要处理的元素，左指针 left\textit{left}left 指向下一个将要赋值的位置。
    *
    * 如果右指针指向的元素不等于 val\textit{val}val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，然后将左右指针同时右移；
    *
    * 如果右指针指向的元素等于 val\textit{val}val，它不能在输出数组里，此时左指针不动，右指针右移一位。
    *
    * 整个过程保持不变的性质是：区间 [0,left)[0,\textit{left})[0,left) 中的元素都不等于 val\textit{val}val。当左右指针遍历完输入数组以后，left\textit{left}left 的值就是输出数组的长度。
    *
    * 这样的算法在最坏情况下（输入数组中没有元素等于 val\textit{val}val），左右指针各遍历了数组一次。
    *
    *
    *
    * 作者：力扣官方题解
    * 链接：https://leetcode.cn/problems/remove-element/solutions/730203/yi-chu-yuan-su-by-leetcode-solution-svxi/
    * 来源：力扣（LeetCode）
    * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * @param nums
    * @param val
    * @return
    */
   public static int removeElement(int[] nums, int val) {
      int n = nums.length;
      int left = 0;
      for (int right = 0; right < n; right ++) {
         if (nums[right] != val){
            nums[left] = nums[right];
            left ++;
         }
      }
      return left;
   }

   /**
    * 方法2
    * @param
    */
   public int removeElement2(int[] nums, int val) {
     int left = 0;
     int right = nums.length;

     while (left < right) {
        if (nums[left] == val) {
           nums[left] = nums[right - 1];
           right --;
        } else {
           left ++;
        }
     }
     return left;
   }

   public static void main(String[] args) {
      int[] nums = new int[]{2,3,2,5,6,8};
      int left = removeElement(nums,2);
      for (int i = 0; i < nums.length; i++) {
         System.out.println(nums[i]);
      }
      System.out.println("left --->" + left);
   }
}
