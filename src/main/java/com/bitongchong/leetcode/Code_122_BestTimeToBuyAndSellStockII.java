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
}
