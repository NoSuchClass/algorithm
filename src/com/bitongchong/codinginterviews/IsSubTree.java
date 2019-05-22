package com.bitongchong.codinginterviews;

public class IsSubTree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean res = false;
    	if (root1 != null && root2 != null) {

			if (root1.val == root2.val) {
				res = isSubTree(root1, root2);
			}
			if (!res) {
				res = HasSubtree(root1.left, root2);
			}
			if (!res) {
				res = HasSubtree(root1.right, root2);
			}
			return res;
		}
    	return res;
    }
    public boolean isSubTree(TreeNode node1, TreeNode node2) {
    	if (node2 == null) {
			return true;
		}
    	if (node1 == null) {
			return false;
		}
    	if (node1.val != node2.val) {
			return false;
		}
    	return isSubTree(node1.left, node2.left) && isSubTree(node1.right, node2.right);
    }
}
