package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @description 删除排序数组中的重复项
 * @date 2019/12/2
 */
public class Code_026_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curIndex = 0;
        int sameNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != sameNum) {
                nums[curIndex + 1] = nums[i];
                curIndex++;
                sameNum = nums[i];
            }
        }
        return curIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int i = new Code_026_RemoveDuplicates().removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}
