package com.gavin.datastructure.bytedance;

class 最小的路径和 {
    public int minPathSum(int[][] grid) {
        int sum = grid[0][0];
        
        int lengh = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < lengh; i++) {
            for (int j = 0; j < width; j ++) {
                sum = sum + grid[i + 1][j];
            }
        }
        return 0;
    }
}
