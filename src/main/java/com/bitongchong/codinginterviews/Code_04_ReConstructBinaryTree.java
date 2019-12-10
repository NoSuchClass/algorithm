package com.bitongchong.codinginterviews;

/**
 * @author liuyuehe
 * @description 中前序重构二叉树
 * 总体思路：二叉树的结构实际上是非常适合递归的。同时，前序时，数组中第一个数一定会是当前递归的根节点
 * 那么它的左右结构就一定能够化为下一个子问题，即再找出以当前根节点的前序数组，然后它的第一个就是根节点
 * 找到根节点之后，需要再找左右子节点，由于中序数组是先左后右的原因，因此可以在in数组中找出pre数组中的
 * 第一个数值，确定好位置之后，它的左边相当于就是通过根节点的左、右子树的前中序数组来构建二叉树，即可递
 * 归求解
 * @date 2019/8/9
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

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 像这种有数组，以及需要在数组中进行递归操作的，可以直接传入数组+数组index来实现
        return func(pre, 0, pre.length - 1,
                in, 0, in.length - 1);
    }

    private TreeNode func(int[] pre, int preStart, int preEnd, int[] in,
                         int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        // 这儿是一个易错点，因为很有可能携程i < inEnd（但是实际上inEnd这个位置依旧在in中有数值）
        for (int i = inStart; i <= inEnd; i++) {
            // 此处用来寻找在in数组中，pre数组第一个值所在的位置（即当前根节点在中序遍历中的位置），
            // 确认好位置之后，就能够确认下一个子问题所需要的前中序数组（即以左右子节点为根节点重构
            // 二叉树的问题）
            if (in[i] == pre[preStart]) {
                // 这儿也是选用数组Index来进行递归的原因，比较方便。如果每次都重构数组，那么需要
                // 保存每次数组的状态，非常麻烦
                node.left = func(pre, preStart + 1, preStart + i - inStart,
                        in, inStart, i - 1);
                node.right = func(pre, preStart + i - inStart + 1, preEnd,
                        in, i + 1, inEnd);
            }
        }
        // 直接返回node实际上返回的依旧是根节点，所以不用再这个函数中保存函数node的状态
        return node;
    }
}