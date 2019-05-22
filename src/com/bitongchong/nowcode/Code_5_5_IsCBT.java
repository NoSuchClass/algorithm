package com.bitongchong.nowcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 问题描述：
 * 判断一颗树是否为完全二叉树
 * 
 * 思路：
 * 分为三种情况：1、如果当前节点既有左节点，又有右节点，继续循环
 * 2、如果只有右节点，没有左节点，返回false
 * 3、如果有左节点，没有右节点，那么剩下的所有节点都应该是叶子节点
 * 4、如果既没有左节点有没有右节点，和3一样
 * 
 * 难点：
 * 二叉树的分层遍历（打印或者是访问）：用一个队列来存储每一个节点，然后每个循环将最先放入的那个节点poll出来
 * 判断这个节点是否有左节点右节点，如果有，存入队列中，当队列为空的时候，就代表着分层遍历的结束
 */
public class Code_5_5_IsCBT {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Boolean isCompleteBinaryTree(Node head) {
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(head);
		Boolean leaf = false;
		Node left = null;
		Node right = null;
		while(!queue.isEmpty()) {
			head = queue.poll();
			left = head.left;
			right = head.right;
			if ((leaf && (head.left != null || head.right != null)) || (right != null && left == null)) {
				return false;
			}
			if (left != null) {
				queue.offer(left);
			}
			if (right != null) {
				queue.offer(right);
			}else {
				leaf = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
//		head.left.left = new Node(4);
//		head.left.right = new Node(5);
//		head.right.left = new Node(6);
//		head.right.right = new Node(7);
//		head.right.right.right = new Node(7);
//		head.right.right.right.right = new Node(7);
//		head.right.right.right.right.right = new Node(7);
 		System.out.println(isCompleteBinaryTree(head));

	}
}
