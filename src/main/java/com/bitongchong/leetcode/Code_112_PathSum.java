package com.bitongchong.leetcode;

import java.util.*;

/**
 * @author liuyuehe
 * @date 2020/7/7 8:14
 */
public class Code_112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
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
