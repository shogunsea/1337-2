// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
	// Recursion : bottom-up approach!!!
    // public int minDepth(TreeNode root) {
    // 	if(root ==  null){
    // 		return 0;
    // 	}

    // 	if(root.left == null && root.right == null){
    // 		return 1;
    // 	}

    // 	if(root.left == null){
    // 		return minDepth(root.right) + 1;
    // 	}else if(root.right == null){
    // 		return minDepth(root.left) + 1;
    // 	}

    // 	int left = minDepth(root.left);
    // 	int right = minDepth(root.right);

    // 	return left > right? right + 1 : left + 1;
    // }


	// recursion : top-down approach!!
    public int minDepth(TreeNode root){
    	if(root == null) return 0;
    	
    	int[] res = {Integer.MAX_VALUE};

    	dfs(res, root, 1);

    	return res[0];
    }

    public void dfs(int[] res, TreeNode node, int depth){
    	if(node.left == null && node.right == null){
    		res[0] = Math.min(res[0], depth);
    		return;
    	}

    	depth++;
    	if(depth > res[0]){
    		// back-tracking
    		return;
    	}

    	if(node.left != null){
    		dfs(res, node.left, depth);
    	}

    	if(node.right != null){
    		dfs(res, node.right, depth);
    	}
    }
}