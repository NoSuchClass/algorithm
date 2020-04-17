package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/17 20:21
 */
public class Code_063_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grid = new int[m][n];
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        grid[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                if (grid[i - 1][0] != 0) {
                    grid[i][0] = 1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                if (grid[0][i - 1] != 0) {
                    grid[0][i] = 1;
                }
            }

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x = 0;
                int y = 0;
                if (obstacleGrid[i - 1][j] == 0) {
                    x = grid[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    y = grid[i][j - 1];
                }
                grid[i][j] = x + y;

            }
        }
        return grid[m - 1][n - 1];
    }
}
