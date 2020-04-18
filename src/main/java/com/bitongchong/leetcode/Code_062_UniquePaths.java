package com.bitongchong.leetcode;

import java.util.Arrays;

/**
 * @author liuyuehe
 * @date 2020/4/17 17:51
 */
public class Code_062_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 因为在这里面每个点的路径都是这个点的 上一个点的路径数 + 左边点的路径数 ，因此只要将上一行和本行的数值记录下来就能推导目标点的
     * 路径数，可以将空间复杂度由 O(m * n) 优化为 O(2n)
     *
     * @param m -
     * @param n -
     * @return -
     */
    public int uniquePaths2(int m, int n) {
        int[] preLine = new int[n];
        int[] curLine = new int[n];
        Arrays.fill(preLine, 1);
        Arrays.fill(preLine, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curLine[j] = preLine[j] + curLine[j - 1];
            }
            preLine = curLine.clone();
        }
        return curLine[n - 1];
    }

    /**
     * 从解法二可以看出，我们求一个点需要的是它头上的那个点和它本行左边的那个点，只要有这两个点，那么就能够计算出当前点
     * 所以可以直接将两行数据优化为一行，每次循环都会提前计算它左边的点，这个左边的点就可以理解成本行左边的那个点，而因为
     * 当前点还未进行计算，这个位置上实际存储的数据是它头上的那个点（上一行）的数据，因此空间复杂度优化为O(n)
     *
     * @param m -
     * @param n -
     * @return -
     */
    public int uniquePaths3(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] += arr[j - 1];
            }
        }
        return arr[n - 1];
    }

}
