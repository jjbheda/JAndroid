package com.gavin.datastructure.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
class 数组中的第K个最大元素 {
    // 通过最大最小值堆是最简单的方式
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1 - n2;
            }
        });

        for (int n : nums) {
           heap.add(n);

           if (heap.size() > k) {
               heap.poll();
           }
        }
        return heap.poll();
    }

}
