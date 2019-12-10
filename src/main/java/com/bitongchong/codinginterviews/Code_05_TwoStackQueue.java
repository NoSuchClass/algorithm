package com.bitongchong.codinginterviews;

import java.util.Stack;

/**
 * @author liuyuehe
 * @description 两个栈实现队列：在push的时候一直往stack1去push，取的时候，
 * 先将stack1的数值全放入stack2中，直到全部放完，以后取值，只要stack2不为空，就都从这里面取
 * 如果为空了，那么从stack1中取数据，如果stack1也没有，那么抛异常
 * @date 2019/8/9
 */
public class Code_05_TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 注意一下小细节，思考一下异常会完善很多
        if (stack1.isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
