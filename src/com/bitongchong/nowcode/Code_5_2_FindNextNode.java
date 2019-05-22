package com.bitongchong.nowcode;

/*
 * 在二叉树中找到一个节点的后继节点
 * 【题目】 现在有一种新的二叉树节点类型如下：
 * public class Node { 
 * 		public int value;
 * 		public Node left;
 * 		public Node right; 
 * 		public Node parent;
 *		public Node(int data) { 
 *			this.value = data; 
 *		}
 *}
 *该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 *假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向
 *自己的父节点，头节点的parent指向null。
 *只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。在二叉树的中序遍历的序列中， 
 *node的下一个节点叫作node的后继节
 *
 *解题思路：观察二叉树的结构后可以总结出两条规律：如果给出节点有右子树，那么右子树最左的左子树就是答案
 *如果没有右子树，那么当头结点的右子树是当前节点时，就是答案（如果不满足，那么就让当前节点指向当前节点的
 *父节点，再和其头结点进行比较）。如果比较到根节点（父节点指向空）就表明没有，返回null
 */
public class Code_5_2_FindNextNode {
	public static class Node{
		public int value;
		public Node parent;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value = val;
		}
	}
	public static Node findNextNode(Node head) {
		Node resNode = head.parent;
		if (head.right != null) { 
			head = head.right;
			while(head.left != null) {
				head = head.left;
			}
			return head;
		}else {
			while(resNode != null) {
				if (resNode.left != null && resNode.left == head) {
					return resNode;
				}else {
					head = resNode;
					resNode = resNode.parent;
				}
			}
			return null;
		}
	}
	
	public static Node findPerNode(Node head) {
		Node resNode = head.parent;
		if (head.left != null) { 
			head = head.left;
			while(head.right != null) {
				head = head.right;
			}
			return head;
		}else {
			while(resNode != null) {
				if (resNode.right != null && resNode.right == head) {
					return resNode;
				}else {
					head = resNode;
					resNode = resNode.parent;
				}
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test));
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
	}
	private static Node getSuccessorNode(Node test) {
		return findPerNode(test);
	}

}
