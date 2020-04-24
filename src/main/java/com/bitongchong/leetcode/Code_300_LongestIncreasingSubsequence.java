package com.bitongchong.leetcode;

import java.util.Arrays;

/**
 * @author liuyuehe
 * @date 2020/4/23 19:20
 */
public class Code_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Code_300_LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i] += 1;
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
