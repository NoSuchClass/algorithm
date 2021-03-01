package com.bitongchong.learningspace.doing.workspace;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2021/1/24 10:34
 */
public class Code_42_TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }
    
    public static void main(String[] args){
        new Code_42_TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
