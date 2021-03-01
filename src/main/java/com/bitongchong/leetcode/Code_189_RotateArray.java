package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/12/29 9:31
 */
public class Code_189_RotateArray {
    public void rotate(int[] nums, int k) {
        // 由于可能出现 k 大于数组长度的情况，而实际上将数组往右移动，按题意来实际上是可以循环的，即可以走n个num.length
        // 所以此处一定要提前处理，否则会出现数组越界的情况
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k- 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private void rotateByTempArray(int[] nums, int k) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(k + i) % len] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, len);
    }
}
