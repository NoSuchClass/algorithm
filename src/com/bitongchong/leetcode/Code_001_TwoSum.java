package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 两数之和
 * @date 2019/7/30
 */
public class Code_001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == n) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i:
                new Code_001_TwoSum().twoSum(new int[]{2, 7, 3}, 9)) {
            System.out.println(i);
        }
    }
}
