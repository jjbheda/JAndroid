package com.gavin.datastructure.leetcode.middle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 有序矩阵中第K小的元素 {

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;

        System.out.println(kthSmallest3(matrix, k));

    }

    /**
     * 方法一：直接排序
     * 思路及算法
     *
     * 最直接的做法是将这个二维数组另存为为一维数组，并对该一维数组进行排序。最后这个一维数组中的第 kk 个数即为答案。
     * @param matrix
     * @param k
     * @return
     * 复杂度分析
     *
     * 时间复杂度：O(n^2\log{n})O(n
     * 2
     *  logn)，对 n^2n
     * 2
     *   个数排序。
     *
     * 空间复杂度：O(n^2)O(n
     * 2
     *  )，一维数组需要存储这 n^2n
     * 2
     *   个数。
     */
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;

        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index ++] = num;
            }
        }

        Arrays.sort(sorted);
        return sorted[k - 1];
    }

    /**
     * 方法二：归并排序
     * 思路及算法
     *
     * 由题目给出的性质可知，这个矩阵的每一行均为一个有序数组。问题即转化为从这 nn 个有序数组中找第 kk 大的数，可以想到利用归并排序的做法，归并到第 kk 个数即可停止。
     *
     * 一般归并排序是两个数组归并，而本题是 nn 个数组归并，所以需要用小根堆维护，以优化时间复杂度。
     *
     * 具体如何归并，可以参考力扣 23. 合并K个排序链表。
     * 复杂度分析
     *
     * 时间复杂度：O(k\log{n})O(klogn)，归并 kk 次，每次堆中插入和弹出的操作时间复杂度均为 \log{n}logn。
     *
     * 空间复杂度：O(n)O(n)，堆的大小始终为 nn。
     *
     * 需要注意的是，kk 在最坏情况下是 n^2n
     * 2
     *  ，因此该解法最坏时间复杂度为 O(n^2\log{n})O(n
     * 2
     *  logn)。
     *
     */

    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = matrix.length;
        for (int i = 0; i < n; i ++) {
            pq.offer(new int[]{matrix[i][0], i ,0});
        }

        for (int i =0; i < k -1; i++) {
            int[] now = pq.poll();

            if (now[2] != n -1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }

        return pq.poll()[0];
    }

    /**
     * 方法三：二分查找
     * 思路及算法
     */
    public static int kthSmallest3(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0];
            int right = matrix[n - 1][n - 1];
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (check(matrix, mid, k, n)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

}
