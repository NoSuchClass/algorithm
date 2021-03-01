package com.bitongchong.learningspace.doing.workspace;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuyuehe
 * @date 2021/1/12 23:56
 */
public class Code_239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
