package com.bitongchong.leetcode;

import java.util.*;

/**
 * @author liuyuehe
 * @date 2020/7/7 8:53
 */
public class Code_102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int queueSize = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        res.add(Collections.singletonList(root.val));
        queueSize = queue.size();
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                        list.add(curNode.left.val);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                        list.add(curNode.right.val);
                    }
                }
            }
            if(list.size() > 0) {
                res.add(list);
            }
            queueSize = queue.size();
        }
        return res;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
