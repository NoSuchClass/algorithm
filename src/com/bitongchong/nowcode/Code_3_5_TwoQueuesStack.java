package com.bitongchong.nowcode;

import java.util.LinkedList;
import java.util.Queue;
//用两个队列结构实现栈（可以使用系统自带队列结构）
public class Code_3_5_TwoQueuesStack {
	public static class TwoQueuesStack{
		private Queue<Integer> date;
		private Queue<Integer> help;
		public TwoQueuesStack() {
			date = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}
		public void push(Integer obj) {
			date.offer(obj);
		}
		public Integer pop() {
			if (date.size() == 0) {
				throw new RuntimeException("the stack is empty");
			}
			while(date.size() != 1) {
				help.offer(date.poll());
			}
			Integer temp = date.poll();
			swap();
			return temp;
		}
		public Integer peek() {
			if (date.size() == 0) {
				throw new RuntimeException("the stack is empty");
			}
			while(date.size() != 1) {
				help.offer(date.poll());
			}
			Integer temp = date.poll();
			help.offer(temp);
			swap();
			return temp;
		}
		//易错点：这儿写成public static void swap(Queue<Integer> help ...){}
		//错误原因是这样就不能改变他们的引用或者说是地址
		private void swap() {
			Queue<Integer> temp = date;
			date = help;
			help = temp;
		}
	}
	
	public static void main(String[] args) {
		TwoQueuesStack twoQueuesStack = new TwoQueuesStack();
		twoQueuesStack.push(35);
		twoQueuesStack.push(64346);
		twoQueuesStack.push(3564);
		twoQueuesStack.peek();
		System.out.println(twoQueuesStack.pop());
	}
}
