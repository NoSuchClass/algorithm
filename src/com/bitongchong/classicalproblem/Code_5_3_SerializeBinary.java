package com.bitongchong.classicalproblem;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 问题描述：
 * 序列化和反序列化二叉树
 */
public class Code_5_3_SerializeBinary {
	public static class Node{
		Node left;
		Node right;
		int val;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	public static String serialize(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.val + "!";
		res += serialize(head.left);
		res += serialize(head.right);
		return res;
	}
	
	public static Node reconPreOder(String str) {
		Queue<String> queue = new LinkedList<>();
		String[] strArr = str.split("!");
		for (int i = 0; i < strArr.length; i++) {
			queue.offer(strArr[i]);
		}
		return recon(queue);
	}
	
	public static Node recon(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(val));
		head.left = recon(queue);
		head.right = recon(queue);
		return head;
	}

	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
//		System.out.println(serialize(head));
		head = reconPreOder(serialize(head));
		printTree(head);
	}
}
