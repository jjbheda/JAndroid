package com.gavin.datastructure.leetcode.middle;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
class 路径的数目 {
   public int uniquePaths(int m, int n) {
      int[][] f = new int[m][n];
      for (int i = 0; i < m; i++) {
         f[i][0] = 1;
      }
      for (int j = 0;j < n; j++) {
         f[0][j] = 1;
      }
      // 第一行，第一列已经被赋予默认值1
      for (int i = 1;i < m; i++) {
         for (int j = 1; j < n ; j++) {
            f[i][j] = f[i - 1][j] + f[i][j - 1]; // 当前位置只能是上侧或左侧走来
         }
      }
      return f[m - 1][n - 1];
   }
}
