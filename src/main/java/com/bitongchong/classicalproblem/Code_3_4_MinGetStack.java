package com.bitongchong.classicalproblem;

import java.util.Stack;

/*
 * 问题描述：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】	1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 			2．设计的栈类型可以使用现成的栈结
 */
public class Code_3_4_MinGetStack {
	public static class MinStack{
		private Stack<Integer> stack;
		private Stack<Integer> stackMin;
		private Integer min;
		public MinStack() {
			stack = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}
		public void push(Integer obj) {
			if (stackMin.isEmpty()) {
				stackMin.push(obj);
				stack.push(obj);
			}else {
				//此处易出错，用pop会将原有的数据吐出来
				min = stackMin.peek();
				Integer current_min = obj < min ? obj : min;
				stackMin.push(current_min);
				stack.push(obj);
			}
		}
		public Integer pop() {
			stackMin.pop();
			return stack.pop();
		}
		public Integer getMin() {
			return stackMin.pop();
		}
	}
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(34);
		minStack.push(334);
		minStack.push(-1);
		System.out.println(minStack.getMin());
		System.out.println(minStack.pop());;
		System.out.println(minStack.getMin());
	}
}
