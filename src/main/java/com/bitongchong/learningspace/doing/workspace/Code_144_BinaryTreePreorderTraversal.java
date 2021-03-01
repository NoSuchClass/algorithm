package com.bitongchong.learningspace.doing.workspace;

import com.bitongchong.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liuyuehe
 * @date 2021/1/28 9:20
 */
public class Code_144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    public List<Integer> recursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process(root, res);
        return res;
    }

    private void process(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        process(root.left, res);
        process(root.right, res);
    }
}
