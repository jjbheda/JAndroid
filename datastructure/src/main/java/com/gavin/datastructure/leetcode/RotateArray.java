package com.gavin.datastructure.leetcode;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7};
        int k = 3;
        int newarray[] = rotate2(array,k);

        for (int i = 0; i < newarray.length; i ++) {
            System.out.print(newarray[i]);
        }
    }
    /**
     *  方法 1：暴力
     *  最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
     */

    public static int[] rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        return nums;
    }

    /***
     *  使用额外的数组
     * @param nums
     * @param k
     * @return
     */

    public static int[] rotate2(int[] nums, int k) {

        int[] tempNums = new int[nums.length];

        for (int i = 0; i < nums.length; i ++) {
            tempNums[(i + k) % nums.length] = nums[i];
        }

        for (int i= 0; i < nums.length; i ++) {
            nums[i] = tempNums[i];
        }

        return nums;
    }


}
