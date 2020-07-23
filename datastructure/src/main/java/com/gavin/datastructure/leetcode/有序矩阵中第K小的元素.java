package com.gavin.datastructure.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
示例：

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。    感觉有点歧义.... 如果k=7，返回也是13

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

方法一：直接排序
思路及算法

最直接的做法是将这个二维数组另存为为一维数组，并对该一维数组进行排序。最后这个一维数组中的第 kk 个数即为答案。


方法二：归并排序
思路及算法

由题目给出的性质可知，这个矩阵的每一行均为一个有序数组。问题即转化为从这 nn 个有序数组中找第 kk 大的数，可以想到利用归并排序的做法，归并到第 kk 个数即可停止。

一般归并排序是两个数组归并，而本题是 nn 个数组归并，所以需要用小根堆维护，以优化时间复杂度。

具体如何归并，可以参考力扣 23. 合并K个排序链表。

代码

方法三：二分查找
思路及算法

由题目给出的性质可知，这个矩阵内的元素是从左上到右下递增的（假设矩阵左上角为 matrix[0][0]matrix[0][0]）。以下图为例

上述三种解法，第一种没有利用矩阵的性质，所以时间复杂度最差；第二种解法只利用了一部分性质（每一行是一个有序数列，而忽视了列之间的关系）；第三种解法则利用了全部性质，所以时间复杂度最佳。

这也启示我们要认真把握题目中的条件与性质，更有利于我们解题。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/you-xu-ju-zhen-zhong-di-kxiao-de-yuan-su-by-leetco/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
public class 有序矩阵中第K小的元素 {
   static int matrix[][] = {
           { 1,  5,  9},
        {10, 11, 13},
        {12, 13, 15}
      };
    static HashMap<Integer,Integer> map = new HashMap<>();
    // 直接排序
    public static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }

    // 归并排序
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(matrix,7));
    }

}