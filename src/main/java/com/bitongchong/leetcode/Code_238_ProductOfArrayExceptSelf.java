package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/6/4 8:14
 */
public class Code_238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        int[] res = new int[len];
        leftProduct[0] = 1;
        rightProduct[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i] = leftProduct[i] * rightProduct[i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightProduct = rightProduct * nums[i + 1];
            res[i] = rightProduct * res[i];
        }
        return res;
    }
}
