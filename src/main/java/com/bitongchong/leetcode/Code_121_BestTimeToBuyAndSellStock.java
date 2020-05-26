package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/30 16:41
 */
public class Code_121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(price - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, - prices[i]);
        }
        return dp_i_0;
    }
}
