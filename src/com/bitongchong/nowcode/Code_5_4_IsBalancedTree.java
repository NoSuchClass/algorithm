package com.bitongchong.nowcode;

/*
 * 问题描述：
 * 判断一棵树是否是平衡二叉树
 */
public class Code_5_4_IsBalancedTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static class ReturnDate{
		public boolean isB;
		public int h;
		
		public ReturnDate(Boolean isB,int h) {
			this.isB = isB;
			this.h = h;
		}
	}
	
	public static Boolean isBalance(Node head) {
		return process(head).isB;
	}
	
	public static ReturnDate process(Node head) {
		if (head == null) {
			return new ReturnDate(true, 0);
		}
		ReturnDate leftDate = process(head.left);
		if (!leftDate.isB) {
			return new ReturnDate(false, 0);
		}
		ReturnDate rightDate = process(head.right);
		if (!rightDate.isB) {
			return new ReturnDate(false, 0);
		}
		if (Math.abs(leftDate.h - rightDate.h) > 1) {
			return new ReturnDate(false, 0);
		}
		return new ReturnDate(true, Math.max(leftDate.h , rightDate.h) + 1);
	}
	 
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.right.right = new Node(7);
//		head.right.right.right.right = new Node(7);
//		head.right.right.right.right.right = new Node(7);
		System.out.println(isBalance(head));

	}
}
