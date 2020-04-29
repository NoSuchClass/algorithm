package com.bitongchong.leetcode;

import java.util.Arrays;

/**
 * @author liuyuehe
 * @date 2020/4/29 17:45
 */
public class Code_213_HouseRobberII {
    public static void main(String[] args){
        System.out.println(new Code_213_HouseRobberII().rob(new int[]{1,1,3,6,7,10,7,1,8,5,9,1,4,4,3}));
    }
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        return Math.max(process(Arrays.copyOfRange(nums, 1, len))
                , process(Arrays.copyOfRange(nums, 0, len - 1)));
    }

    public int process(int[] nums) {
        return new Code_198_HouseRobber().rob(nums);
    }
}
