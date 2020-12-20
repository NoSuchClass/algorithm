package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/7/12 19:43
 */
public class Code_174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = dungeon[m - 1][n - 1];
        for (int i = m - 2; i > 0; i--) {
            dp[i][0] = dp[i + 1][0] + dungeon[i][0];
        }
        for (int i = n  - 2; i > 0; i--) {
            dp[0][i] = dp[0][i + 1] + dungeon[0][i];
        }
        for (int i = m - 2; i > 0; i--) {
            for (int j = n - 2; j > 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = dp[i][j] <= 0 ? 1 : dp[i][j];
            }
        }
        return dp[0][0];
    }
}
