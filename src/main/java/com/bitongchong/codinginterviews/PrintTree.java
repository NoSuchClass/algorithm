package com.bitongchong.codinginterviews;

public class PrintTree {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static String print(TreeNode node, String string) {
		if (node.left != null) {
			return print(node.left, string);
		}
		string += node.val;
		if (node.right != null) {
			return print(node.right, string);
		}
		return string;
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
		head.right.right.right = new TreeNode(7);
		String aString = "";
		System.out.println(print(head, aString));
	}
}
