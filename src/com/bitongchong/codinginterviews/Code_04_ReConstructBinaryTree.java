package com.bitongchong.codinginterviews;

/**
 * @author liuyuehe
 * @description 前中序重构二叉树
 * @date 2019/8/1
 */
public class Code_04_ReConstructBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int preStart = 0;
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, preStart, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart,
                                                 int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, i - inStart + preStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
/*		int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode node = reConstructBinaryTree(pre, in);
		System.out.println(node.val);*/
        System.out.println(1 << (-1));
    }
}

