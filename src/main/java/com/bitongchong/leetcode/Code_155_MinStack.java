package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2021/1/6 23:40
 */
public class Code_155_MinStack {

    /**
     * initialize your data structure here.
     */
    private Stack<Integer> commonStack;
    private Stack<Integer> minStack;
    public Code_155_MinStack() {
        commonStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        commonStack.add(x);
        if (minStack.isEmpty()) {
            minStack.add(x);
        } else {
            minStack.add(minStack.peek() > x ? x : minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        commonStack.pop();
    }

    public int top() {
        return commonStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
