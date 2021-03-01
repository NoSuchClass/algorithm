package com.bitongchong.learningspace.doing.workspace;

import com.bitongchong.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuehe
 * @date 2021/1/28 9:30
 */
public class Code_145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process(root, res);
        return res;
    }

    private void process(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        process(root.left, res);
        process(root.right, res);
        res.add(root.val);
    }
}
