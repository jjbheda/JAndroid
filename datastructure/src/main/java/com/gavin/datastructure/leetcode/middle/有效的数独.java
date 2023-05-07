package com.gavin.datastructure.leetcode.middle;

/**
 * 具体做法是，创建二维数组 rows和 columns分别记录数独的每一行和每一列中的每个数字的出现次数，创建三维数组 subboxes 记录数独的每一个小九宫格中的每个数字的出现次数，其中 rows[i][index]、columns[j][index] 和 subboxes[⌊i3⌋][⌊j3⌋]分别表示数独的第 iii 行第 jjj 列的单元格所在的行、列和小九宫格中，数字 index+1出现的次数，其中 0≤index<90 \le \textit{index} < 90≤index<9，对应的数字 index+1\textit{index} + 1index+1 满足 1≤index+1≤91 \le \textit{index} + 1 \le 91≤index+1≤9。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/valid-sudoku/solutions/1001859/you-xiao-de-shu-du-by-leetcode-solution-50m6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class 有效的数独 {
   public boolean isValidSudoku(char[][] borad) {
      // 定义数字行内出现的次数
      int[][] row = new int[9][9];
      //定义数字列内出现的次数
      int[][] colum = new int[9][9];

      // 定义数字九宫格内出现的次数最大为9次
      int[][][] juugongge = new int[3][3][9];
      // 遍历数组
      for (int i = 0; i < 9; i ++) {
         for (int j = 0 ; j < 9; j ++) {
            char c = borad[i][j];
            //只要存在数字
            if (c !='.') {
               // 把数字-1 化为索引下标，c是字符串要减去字符串，-1会报错
               int index = c-'1';
               // 这时候++意思是第i行这个c值次数+1，默认row第二位就是
              // {1-9}-1

            }
         }
      }
      return false;
   }
}
