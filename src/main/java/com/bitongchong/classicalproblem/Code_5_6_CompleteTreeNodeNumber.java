package com.bitongchong.classicalproblem;

/*
 * 问题描述：
 * 以O(logN)的时间复杂度完成对完全二叉树的节点数的判断
 */
public class Code_5_6_CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static int numCount(Node head) {
		if (head == null) {
			return 0;
		}
		int lH = 0;
		int rH = 0;
		Node curHead = head;
		while(curHead != null) {
			lH++;
			curHead = curHead.left;
		}
		curHead = head;
		while(curHead != null) {
			rH++;
			curHead = curHead.right;
		}
		if (lH == rH) {
			return (1 << lH) - 1;
		}else {
			return 1 + numCount(head.left)+ numCount(head.right);
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
 		head.right = new Node(3);
		head.left.left = new Node(4);
 		head.left.right = new Node(5);
 		head.right.left = new Node(6);
//		head.right.right = new Node(7);
//		head.right.right.right = new Node(7);
//		head.right.right.right.right = new Node(7);
//		head.right.right.right.right.right = new Node(7);
 		System.out.println(numCount(head));
	}
}
