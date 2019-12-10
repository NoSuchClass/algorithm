package com.bitongchong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    /**
     * 使用空间换时间
     * @param nums 输入数组
     * @param target 目标数字
     * @return 结果
     */
    public int[] twoSumPlus(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
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
