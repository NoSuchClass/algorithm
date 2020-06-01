package com.bitongchong.leetcode;

import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2020/5/31 10:01
 */
public class Code_101_SymmetricTree {
    private Stack<TreeNode> stack = new Stack<>();
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkByRecursive(root.left, root.right);
    }

    private boolean checkByRecursive(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null) {
            return tree1 == null && tree2 == null;
        }
        return tree1.val == tree2.val && checkByRecursive(tree1.left, tree2.right) && checkByRecursive(tree1.right, tree2.left);
    }

    private boolean checkByIterator(TreeNode tree1, TreeNode tree2) {
        stack.push(tree1);
        stack.push(tree2);
        while(!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
