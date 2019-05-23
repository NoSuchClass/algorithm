package com.bitongchong.classicalproblem;

import java.util.Stack;

/*
 * 先序中序后序遍历二叉树（递归版和非递归版）
 */
public class Code_5_1_PreInPosTraversal {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value+" ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value+" ");
		inOrderRecur(head.right);
	}
	
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value+" ");
	}
	
	public static void preOrderUnRecur(Node head) {
		//一般在需要来回两次判断时，就需要栈而不是队列
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while(!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value+" ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
	}
	
	public static void inOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			//精华所在，当一个while中还需要写while时，可以将两个while的条件集中到一个更高层次的while中
			//然后在内部用if判断每一段程序的入口所在
//			while(!stack.isEmpty() || head != null) {
//				while (head != null) {
//					stack.push(head);
//					head = head.left;
//				}
//				while(stack.isEmpty()) {
//					head = stack.pop();
//					System.out.print(head.value+" ");
//					head = head.right;
//				}
//			}
			while(!stack.isEmpty() || head != null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			}else {
				head = stack.pop();
				System.out.print(head.value+" ");
				head = head.right;
			}
		}
		}
	}
	
	public static void posOrderUnRecur(Node head) {
		Stack<Node> stack = new Stack<>();
		Stack<Node> resStack = new Stack<>();
		stack.push(head);
		while(!stack.isEmpty()) {
			//菜鸡写法，以后按照思路严格翻译
//			if (head.right != null) {
//				resStack.push(stack.pop());
//				stack.push(head.left);
//				stack.push(head.right);
//				head = head.right;
//			}else {
//				resStack.push(stack.pop());
//				head = stack.peek();
//			}
			head = stack.pop();
			resStack.push(head);
			if (head.left != null) {
				stack.push(head.left);
			}
			if (head.right != null) {
				stack.push(head.right);
			}
		}
		while(!resStack.isEmpty()) {
			head = resStack.pop();
			System.out.print(head.value+" ");
		}
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

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

//		// unrecursive
		System.out.println("============unrecursive=============");
		preOrderUnRecur(head);
		System.out.println();
		inOrderUnRecur(head);
		System.out.println();
		posOrderUnRecur(head);
//		posOrderUnRecur2(head);

	}

}
