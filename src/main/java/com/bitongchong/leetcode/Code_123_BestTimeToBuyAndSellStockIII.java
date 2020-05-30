package com.bitongchong.leetcode;

import java.util.Arrays;

/**
 * @author liuyuehe
 * @date 2020/4/30 17:19
 */
public class Code_123_BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        System.out.println(new Code_123_BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        // dp[天数][卖出的次数][当前是否持股]
        int[][][] dp = new int[len][3][2];
        for (int i = 2; i > 0; i--) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 2; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][2][0];
    }
}
