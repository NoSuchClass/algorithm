package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/25 9:30
 */
public class Code_053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? nums[i] + dp[i - 1] : nums[i];
        }
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
