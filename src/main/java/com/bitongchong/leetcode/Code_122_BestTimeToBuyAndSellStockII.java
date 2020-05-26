package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/30 17:02
 */
public class Code_122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                totalProfit = (price - minPrice) + totalProfit;
                minPrice = price;
            }
        }
        return totalProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public int maxProfit3(int[] prices) {
        int[][] dp = new int[prices.length][2];
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }
}
