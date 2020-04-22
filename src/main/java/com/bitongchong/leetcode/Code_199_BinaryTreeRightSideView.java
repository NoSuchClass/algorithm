package com.bitongchong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liuyuehe
 * @date 2020/4/22 11:32
 */

public class Code_199_BinaryTreeRightSideView {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> tempQueue = new LinkedList<>();
    Queue<TreeNode> nodeQueue = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                // 这两个if和这个for循环都是用来存储下一层节点的
                TreeNode node = nodeQueue.poll();
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }

                // 将本层的最后一个节点值存入结果列表中
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
