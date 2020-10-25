package com.gavin.datastructure.leetcode;

import java.util.Iterator;


/**
 * 通过 最大值堆的方式
 */
class 数组中的第K个最大元素4 {
    static int[] arr = {8, 9, 10, 11, 12, 13, 14};

    public static void main(String[] args) {
        /*
         * 调用建立大顶堆方法：
         * index：传入最后一个非叶子节点，即list.size()/2-1;
         * */

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            buildHeap(arr, i, arr.length);
        }
        System.out.println("输出最大堆：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("升序排列结果：");
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void buildHeap(int[] arr, int index, int size) {
        int leftchild = 2 * index + 1;
        int rightchild = 2 * index + 2;
        int temp = index;
        if (leftchild < size && arr[index] < arr[leftchild]) {
            index = leftchild;
        }
        if (rightchild < size && arr[index] < arr[rightchild]) {
            index = rightchild;
        }
        if (index != temp) {
            swap(arr, temp, index);
            // 交换后继续向下调整,以index为父节点，继续向下调整
            buildHeap(arr, index, size);
        }
    }

    /*
     * 堆排序：
     *		1)将已经建立好的大顶堆，每次取出根节点，即最大值。
     *		2)将最后一个节点的值赋给根节点，重新构建大顶堆。
     *		3)删除最后节点的数据
     * */
    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            // 从根节点向下调整，每次取出一个数值，集合长度逐渐减小
            buildHeap(arr, 0, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
