package com.gavin.datastructure.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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

public class 数组中的第K个最大元素2 {
   public static int[] nums = {3,2,1,5,5,4,6,7};

    public static void main(String[] args) {
        数组中的第K个最大元素2 test = new 数组中的第K个最大元素2();
        System.out.println(test.findKthLargest(nums,3));
    }
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        // 要找到的元素所在索引:  前K大，即倒数索引第K个
        int index = nums.length - k;
        int right = nums.length - 1;
        int left = 0;
        return quickSelect(nums, left, right, index);
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        // 得到分区值索引q
        int q = randomPartition(nums, left, right);


        if (q == index) {
            // 如果刚好索引q就是想要的索引，则直接返回
            return nums[q];

        } else {
            // 如果不是，比较q 与 index ,确定下次要检索的区间, 要么是[q+1, right], 要么就是[left, q-1]
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int l, int r) {
        // 1. 随机数范围: [0, r-l+1) 同时加l, 则是 [l, r+1) = [l, r] 也就是在这个[l,r] 中随机选一个索引出来
        int i = random.nextInt(r - l + 1) + l;

        // 2. 交换nums[i]， nums[r], 也就是将随机数先放在[l,r]最右边nums[r]上
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        // 3. 在调用当前方法的randomPartition方法中，已经确定了了随机数是nums[r]
        int x = nums[r], i = l - 1;

        // 首先比较区间在[l， r]之间， 所以nums[j]中的    l<= j <= r
        for (int j = l; j < r; ++j) {
            // 4. nums[j] 跟随机数 x 比较, 小于x的数都跟[l,r]左边区间交换，i=l-1,所以++i=l,初始索引就是l,
            if (nums[j] <= x) {
                swap(nums, ++i, j);//两两交换
            }
        }// 这个for循环操作就是将小于 x 的数都往[i, j]的左边区间设置，从而实现存在[l, i]区间,使得对应数值都 小于 x

        //5. 既然已经将<x的值都放在一边了，现在将x也就是nums[r] 跟nums[i+1]交换，从而分成两个区间[l.i+1]左, [i+2, r]右，左边区间的值都小于x
        swap(nums, i + 1, r);

        // 然后返回这个分区值
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
