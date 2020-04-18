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

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] arr = new int[n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            arr[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0 && j != 0) {
                    arr[j] += arr[j - 1];
                }
                if (obstacleGrid[i][j] != 0) {
                    arr[j] = 0;
                }
            }
        }
        return arr[n - 1];
    }

    /**
     * 因为给了个数组，可以直接使用，优化空间复杂度O(1)
     * @param obstacleGrid -
     * @return -
     */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
    public static void main(String[] args){
        System.out.println(new Code_063_UniquePathsII().uniquePathsWithObstacles3(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
