package com.bitongchong.nowcode;

/*
 * 问题描述：
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class Code_8_6_PrintAllSubsquence {
	// 使用队列是不行的，虽然简化了递归时候的case判断，但是在每种基准条件出现的时候不能很好地实现
	// 一种添加，一种不添加数组
//	public static void printAllSubsquence(String str) {
//		char[] arr = str.toCharArray();
//		Queue<String> queue = new PriorityQueue<>();
//		for (int i = 0; i < arr.length; i++) {
//			queue.offer(String.valueOf(arr[i]));
//		}
//		String string = "";
//		process(queue , string);
//	}
//	public static void process(Queue<String> queue, String string) {
//		if (queue.isEmpty()) {
//			System.out.println(string);
//			return;
//		}
//		process(queue, string+queue.poll());
//		System.out.println(string);
//		queue.poll();
//		process(queue, string);
//		System.out.println(string);
//	}
//	

	public static void printAllSubsquence(String str) {
		char[] arr = str.toCharArray();
		int i = 0;
		String res = "";
		process(arr, i, res);
	}

	public static void process(char[] arr, int i, String res) {
		if (i == arr.length) {
			System.out.println(res);
			return;
		}
		process(arr, i + 1, res+arr[i]);
		process(arr, i + 1, res);
	}
	
	public static void main(String[] args) {
	String str = "ag";
	printAllSubsquence(str);
}
}
