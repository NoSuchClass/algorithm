package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/6/7 10:36
 */
public class Code_5428_ReArray {
    public int[] shuffle(int[] nums, int n) {
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index++] = nums[i];
            res[index++] = nums[n + i];
        }
        return res;
    }
}
