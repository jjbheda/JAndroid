package com.gavin.datastructure.sort;

/**
 * 归并排序
 */
class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,8,7};
        merge_sort(arr);
        System.out.println(arr);
    }

    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        mergeAndSort(arr, result, 0, len - 1);
    }
    // 递归方式
    public static void mergeAndSort(int[] arr, int[] result, int start, int end) {

        if (start >= end) {
            return;
        }
        int len = end - start;
        int mid = (len >>1) + start;

        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        mergeAndSort(arr, result, start1, end1);
        mergeAndSort(arr, result, start2, end2);

        int k = start;

        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1 ++] : arr[start2 ++];
        }

        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }

        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for ( k = start; k <= end; k++) {
            arr[k] = result[k];
        }


    }
}
