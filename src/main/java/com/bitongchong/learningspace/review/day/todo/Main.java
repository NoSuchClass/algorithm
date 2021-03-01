package com.bitongchong.learningspace.review.day.todo;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuyuehe
 * @date 2021/1/23 15:42
 */
public class Main {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && (queue.peekFirst() == i - k)) {
                queue.pollFirst();
            }
            while(nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
    
    public static void main(String[] args){
        new Main().maxSlidingWindow(new int[]{4,3,11}, 3);
    }
}
