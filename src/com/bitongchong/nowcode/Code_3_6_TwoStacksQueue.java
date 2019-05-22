package com.bitongchong.nowcode;

import java.util.Stack;
//解决问题，用栈实现队列（可以用系统提供的栈结构）
public class Code_3_6_TwoStacksQueue {
	public static class TwoStacksQueue{
		private Stack<Integer> pushStack;
		private Stack<Integer> popStack;
		public TwoStacksQueue() {
			pushStack = new Stack<Integer>();
			popStack = new Stack<Integer>();
		}
		//这儿添加static 就会读取不到pushStack popStack，原因是static方法可以直接通过类名来访问，而不需要创建一个类的实例
		//所以pushStack popStack没有实例化，不能读取
		public void push(Integer obj) {
			if (popStack.size() == 0) {
				pushStack.push(obj);
			}else {
				while(pushStack.size()>0) {
					pushStack.push(popStack.pop());
				}
				popStack.push(obj);
			}
		}
		public Integer poll() {
			if (pushStack.size()==0) {
				throw new RuntimeException("the queue is empty");
			}
			while(pushStack.size()>0) {
				popStack.push(pushStack.pop());
			}
			Integer res = popStack.pop();
			return res;
		}
	}
	public static void main(String[] args) {
		TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
		twoStacksQueue.push(343);
		twoStacksQueue.push(345634);
		System.out.println(twoStacksQueue.poll());
	}
}
