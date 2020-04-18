package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/4/18 17:23
 */
public class Code_011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = Integer.MIN_VALUE;
        while(left < right) {
            int distance = right - left;
            int curWater;
            if (height[left] >= height[right]) {
                curWater = height[right] * distance;
                right--;
            } else {
                curWater = height[left] * distance;
                left++;
            }
            mostWater = Math.max(mostWater, curWater);
        }
        return mostWater;
    }
}
