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
}
