package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/5/30 22:25
 */
public class Code_084_LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new Code_084_LargestRectangleInHistogram().largestRectangleArea(new int[]{1}));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                res = Math.max(res, h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return res;
    }
}
