package com.bitongchong.nowcode;

//问题：用数组实现大小固定的栈和队列
public class Code_3_3_ArrayStackAndArrayQueue {
	public static class ArrayStack{
		private static Integer[] arr;
		private static Integer index;
		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("the init size is less than 0");
			}
			arr = new Integer[initSize];
			index = 0;
		}
		public void push(int obj) {
			if (index == arr.length) {
				throw new  ArrayIndexOutOfBoundsException("the stack is full");
			}
			arr[index++] = obj;
		}
		public Integer peek() {
			if (index == 0) {
				return null;
			}
			return arr[index-1];
		}
		public Integer pop() {
			if (index == 0) {
				throw new ArrayIndexOutOfBoundsException("the stack is empty");
			}
			return arr[--index];
		}
	}
	public static class ArrayQueue{
		private static Integer[] arr;
		private static Integer start;
		private static Integer end;
		private static Integer size;
		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("the init size is less than 0");
			}
			arr = new Integer[initSize];
			start = 0;
			end = 0;
			size = 0;
		}
		public void offer(Integer obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("the queue is full");
			}
			arr[end] = obj;
			end = end==(arr.length-1)?0:++end;
			size++;
		}
		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("the queue is empty");
			}
			int temp = arr[start];
			start = start==(arr.length-1)?0:++start;
			size--;
			return temp;
		}
	}
	public static void main(String[] args) {
//		ArrayStack arrayStack = new ArrayStack(3);
//		arrayStack.push(22);
//		System.out.println(arrayStack.peek());
//		arrayStack.push(2);
//		System.out.println(arrayStack.peek());
//		arrayStack.push(45);
//		System.out.println(arrayStack.peek());
//		System.out.println(arrayStack.pop());
//		System.out.println(arrayStack.pop());
//		System.out.println(arrayStack.pop());
//		System.out.println(arrayStack.pop());
		ArrayQueue arrayQueue = new ArrayQueue(3);
		arrayQueue.offer(3);
//		arrayQueue.offer(33);
//		arrayQueue.offer(344);
		System.out.println(arrayQueue.poll());
		System.out.println(arrayQueue.poll());
	}
}
