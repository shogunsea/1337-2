// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(TreeNode node, int min, int max){
    	if(node == null) return true;

    	if(node.val <= min || node.val >= max){
    		return false;
    	}else{
    		return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    	}
    }
}


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Data {
        boolean isValid;
        int min;
        int max;
        Data(int min, int max, boolean isValid) {
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Data res = helper(root);
        return res == null || res.isValid;
    }

    public Data helper(TreeNode node) {
        if (node == null) {
            return null;
        }

        Data left = helper(node.left);
        Data right = helper(node.right);
        Data res = new Data(0,0, false);

       // left invalid
        if (left != null && !left.isValid) {
            return res;
        }
        // right invalid
        if (right != null && !right.isValid) {
            return res;
        }

        if (left == null) {
            res.min = node.val;
        } else {
            if (left.max >= node.val || left.min >= node.val) {
                res.isValid = false;
                return res;
            } else {
                res.min = left.min;
            }
        }

        if (right == null) {
            res.max = node.val;
        } else {
            if (right.min <= node.val ) {

                res.isValid = false;
                return res;
            } else {
                res.max = right.max;
            }
        }

        res.isValid = true;

        return res;
    }
}