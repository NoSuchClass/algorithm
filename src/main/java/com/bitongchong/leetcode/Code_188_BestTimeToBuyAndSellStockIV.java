package com.bitongchong.leetcode;

import java.util.Arrays;

/**
 * @author liuyuehe
 * @date 2020/5/25 20:45
 */
public class Code_188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        if(2 * k > len) {
            int profit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += (prices[i] - prices[i - 1]);
                }
            }
            return profit;
        }
        // dp[天数][卖出的次数][当前是否持股]
        int[][][] dp = new int[len][k + 1][2];
        for (int i = k; i > 0; i--) {
            // 实际上就是解dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]); 因为需要i为0的情况，那么
            // 这个时候，就需要知道 dp[-1][j][1]和dp[-1][j - 1][0]的值为多少，而dp[-1][j][1]这种情况是不存在的，也是很多题解中
            // 有初始化这个值为Integer.MIN_VALUE的原因，dp[-1][j - 1][0]由于不持有股票，因此为0，故而dp[0][i][1]直接初始化为-prices[0]，
            // 这里base-case本质上就是对第一天这种特殊情况进行了一个初始化而已，方便后续推导。
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }


    public int maxProfit2(int k, int[] prices) {
        if (k >= prices.length >>> 1) {
            // 这个地方的T_ik1实际上初始化的是上面哪种解法的dp[-1][i][1]，代表在不能够购买股票的时候是不应该持有股票的，和上面一种方
            // 法不同的是，此处是初始化的dp[-1][k][1]和dp[-1][k][0]这两种情况，两者的值上个题解有说明
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }
        return T_ik0[k];
    }

}
