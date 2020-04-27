package com.gavin.datastructure.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 方法零：排序
 * 最朴素的方法是先对数组进行排序，再返回倒数第 k 个元素，就像 Python 中的 sorted(nums)[-k]。
 * 算法的时间复杂度为 O(N \log N)O(NlogN)，空间复杂度为 O(1)O(1)。这个时间复杂度并不令人满意，让我们试着用额外空间来优化时间复杂度。
 *
 * 方法一：堆
 * 思路是创建一个大顶堆，将所有数组中的元素加入堆中，并保持堆的大小小于等于 k。这样，堆中就保留了前 k 个最大的元素。这样，堆顶的元素就是正确答案。
 *
 * 像大小为 k 的堆中添加元素的时间复杂度为 {O}(\log k)O(logk)，我们将重复该操作 N 次，故总时间复杂度为 {O}(N \log k)O(Nlogk)。
 *
 * 在 Python 的 heapq 库中有一个 nlargest 方法，具有同样的时间复杂度，能将代码简化到只有一行。
 *
 * 本方法优化了时间复杂度，但需要 {O}(k)O(k) 的空间复杂度。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class 数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
// init heap 'the smallest element first'
        int DEFAULT_INITIAL_CAPACITY = 11;
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}
