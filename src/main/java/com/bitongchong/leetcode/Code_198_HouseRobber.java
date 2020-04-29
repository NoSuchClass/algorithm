package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/29 17:07
 */
public class Code_198_HouseRobber {
    /**
     * 较low的做法，时间复杂度特别高
     * @param nums -
     * @return -
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], nums[i] + dp[j]);
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
