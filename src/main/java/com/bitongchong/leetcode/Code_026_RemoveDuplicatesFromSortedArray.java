package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/12/29 8:28
 */
public class Code_026_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        int fastIndex = 0;
        while(fastIndex < nums.length) {
            if (nums[fastIndex] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
            fastIndex++;
        }
        return slowIndex + 1;
    }
}
