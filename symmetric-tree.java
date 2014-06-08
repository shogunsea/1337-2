// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

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
    public boolean isSymmetric(TreeNode root) {
    	if(root == null){
    		return true;
    	}	

    	return symm(root.left, root.right);
	}

	public boolean symm(TreeNode left, TreeNode right){
		if(left == null){
			return right == null;
		}else if(right == null){
			return false;
		}

		if(left.val != right.val){
			return false;
		}

		if(!symm(left.left, right.right)){
			return false;
		}

		if(!symm(left.right, right.left)){
			return false;
		}

		return true;
	}
}