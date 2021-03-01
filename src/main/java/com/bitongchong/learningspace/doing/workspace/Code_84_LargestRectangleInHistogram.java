package com.bitongchong.learningspace.doing.workspace;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2021/1/11 23:04
 */
public class Code_84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                int curHeight = temp[stack.pop()];
                int curLength = (i - stack.peek() - 1);
                res = Math.max(curHeight * curLength, res);
            }
            stack.push(i);
        }
        return res;
    }
}
