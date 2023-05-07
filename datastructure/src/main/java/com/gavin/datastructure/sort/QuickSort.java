package com.gavin.datastructure.sort;

/**
 * 快速排序使用分治法策略来把一个序列分为两个子序列，基本步骤为：
 *
 * 先从序列中取出一个数作为基准数；
 * 分区过程：将把这个数大的数全部放到它的右边，小于或者等于它的数全放到它的左边；
 * 递归地对左右子序列进步骤2，直到各区间只有一个数。
 *
 * 虽然快排算法的策略是分治法，但分治法这三个字显然无法很好的概括快排的全部不走，因此借用 CSDN 神人 MoreWindows 的定义说明为：挖坑填数 + 分治法。
 *
 * https://blog.csdn.net/shujuelin/article/details/82423852
 */
public class QuickSort {

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j --;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i ++;
            }
            //如果满足条件则交换
            if (i < j) {
//                t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
                swap(arr, i, j);
            }

        }
        //最后将基准为与i和j相等位置的数字交换  初始基准数字是arr[low]的值，探测结束时，需要把基准位跟最终碰头的值交换
        //https://blog.csdn.net/shujuelin/article/details/82423852
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    public static void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }


    public static void main(String[] args){
//        int[] arr = {2,6,1,3,9,34,27,18,28,87,73,90};
        int[] arr = {2,6,1,3,9,8};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
