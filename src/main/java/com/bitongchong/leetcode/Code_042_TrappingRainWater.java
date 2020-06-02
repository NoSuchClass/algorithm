package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/6/1 16:00
 */
public class Code_042_TrappingRainWater {
    public static void main(String[] args){
        System.out.println(new Code_042_TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftMax = stack.peek();
                res += (i - leftMax - 1) * (Math.min(height[i], height[leftMax]) - height[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = height.length - 1;
        while(left <= right) {
            if (height[leftMax] < height[rightMax]) {
                res += Math.max(0, (left - leftMax) * height[left]);
                leftMax = height[left] >= height[leftMax] ? left : leftMax;
                left++;
            } else {
                res += Math.max(0, (rightMax - right) * height[right]);
                rightMax =height[right] >= height[rightMax] ? right : rightMax;
                right--;
            }
        }
        return res;
    }
}
