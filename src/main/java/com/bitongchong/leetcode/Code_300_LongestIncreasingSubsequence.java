package com.bitongchong.leetcode;

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

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 这个top只存储每堆扑克最上面的那一个扑克
        int[] top = new int[nums.length];
        // 这个的作用是记录当前的所有扑克被分为多少堆，用作二分时的右边界
        int piles = 0;
        for (int poker : nums) {
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] < poker) {
                    left = mid;
                } else if (top[mid] > poker) {
                    right = mid - 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
