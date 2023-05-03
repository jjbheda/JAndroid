package com.gavin.datastructure.leetcode.easy;

class 合并两个有序数组 {
    static int[] nums1 = new int[]{1,2,3};
    static int[] nums2 = new int[]{2,5,6};

    public static void main(String[] args) {
        System.out.println("nums1,5,nums2,2");
        int[] curArr = merge(nums1,nums2);
        for (int i = 0; i <curArr.length ; i++) {
            System.out.println(curArr[i]);
        }
    }

    int k = 0;
    int[] temp = new int[nums1.length];

    // 方法1

    /**
     * 时间复杂度：O(m+n)O(m+n)O(m+n)。 指针移动单调递增，最多移动 m+nm+nm+n 次，因此时间复杂度为 O(m+n)O(m+n)O(m+n)。
     *
     * 空间复杂度：O(m+n)O(m+n)O(m+n)。 需要建立长度为 m+nm+nm+n 的中间数组 sorted\textit{sorted}sorted。
     *
     *
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/merge-sorted-array/solutions/666608/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int[] merge(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            temp[p1 + p2 - 1] = cur;
        }

        return temp;
    }


}
