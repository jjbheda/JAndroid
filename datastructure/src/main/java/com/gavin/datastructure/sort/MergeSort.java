package com.gavin.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 特点：      内存占用高，但是稳定。
 *            充分利用二分法的思想，利用了完全二叉树 深度是log2n + 1的特性，因此效率比较高
 *
 * 基本原理:   对于给定的一组记录，利用递归与分治技术将数据序列划分成为越来越小的半子表，在对半子表排序，
 *            最后再用递归方法将排好序的半子表合并成为越来越大的有序序列。
 *
 * 过程：      先拆分 再聚合
 *
 * 时间复杂度： O(nlog2n)
 * 空间复杂度： O(n)
 *
 * 解题过程，参见 https://www.cnblogs.com/chengxiao/p/6194356.html
 */
class MergeSort {

    public static void main(String[] args) {
        int a[] = { 12, 14, 15, 13, 11, 16 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

}
