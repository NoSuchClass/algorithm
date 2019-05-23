package com.bitongchong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Code_01_MinimumDepthOfBinaryTree {
    public int run(TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            if (node.left == null && node.right == null) break;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (size == 0) {
                res++;
                size = queue.size();
            }
        }
        return res;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
}