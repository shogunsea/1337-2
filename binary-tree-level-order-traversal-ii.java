// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]


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

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
     	List<List<Integer>> res = new ArrayList<List<Integer>>();

    	if(root == null){
    		return res;
    	}

    	Queue<TreeNode> previous = new LinkedList<TreeNode>();
    	List<Integer> current = new ArrayList<Integer>();
    	previous.add(root);

    	while(!previous.isEmpty()){
    		Queue<TreeNode> temp = previous;
    		previous = new LinkedList<TreeNode>();
    		while(!temp.isEmpty()){
    			TreeNode node = temp.poll();
    			current.add(node.val);
    			if(node.left != null){
    				previous.add(node.left);
    			}
    			if(node.right != null){
    				previous.add(node.right);
    			}
    		}

    		res.add(0, current);
    		current = new ArrayList<Integer>();
    	}

    	return res;
    }
}