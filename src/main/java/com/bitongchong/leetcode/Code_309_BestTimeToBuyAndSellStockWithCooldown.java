package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/5/25 17:48
 */
public class Code_309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE >> 1;
        int dp_pre_0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
