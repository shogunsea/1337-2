// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
        	return true;
        }

        return helper(root) != -1? true : false;
    }

    public int helper(TreeNode root){
    	if(root == null){
    		return 0;
    	}

    	int left = helper(root.left);
    	
    	if(left == -1){
    		return -1;
    	}

    	int right = helper(root.right);
    	
    	if(right == -1){
    		return -1;
    	}

    	int height = Math.abs(right - left);
    	
    	if(height > 1){
    		return -1;
    	}

    	return right > left? right + 1 : left + 1;
    }
}