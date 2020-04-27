package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/25 10:34
 */
public class Code_152_MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new Code_152_MaximumProductSubarray().maxProduct1(new int[]{2,3,-2,4}));
    }

    private int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int curMax = nums[0];
        int curMin = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(curMax * nums[i], curMin * nums[i]));
            dp[i] = curMax;
        }
        int res = Integer.MIN_VALUE;
        for (int value : dp) {
            res = Math.max(res, value);
        }
        return res;
    }

    private int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] curMaxDp = new int[nums.length];
        int[] curMinDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        curMaxDp[0] = nums[0];
        curMinDp[0] = nums[0];
        maxDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMaxDp[i] = Math.max(nums[i], Math.max(curMinDp[i - 1] * nums[i], curMaxDp[i - 1] * nums[i]));
            curMinDp[i] = Math.min(nums[i], Math.min(curMinDp[i - 1] * nums[i], curMaxDp[i - 1] * nums[i]));
            maxDp[i] = curMaxDp[i];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(maxDp[i], res);
        }
        return res;
    }

    /**
     * 时间复杂度和空间复杂度都极高
     * @param nums -
     * @return -
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(process(nums, i, i, i), res);
        }
        return res;
    }

    private int process(int[] nums, int i, int end, int res) {
        if (end > nums.length - 1) {
            return res;
        }
        res = i == end ? nums[i] : res * nums[end];
        return Math.max(process(nums, i, end + 1, res), res);
    }


}