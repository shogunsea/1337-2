// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
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
	// recursion
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();

    //     if(root == null){
    //     	return res;
    //     }

    //     dfs(res, root, 1);

    //     return res;
    // }

    // public void dfs(List<List<Integer>> res, TreeNode node, int depth){
    // 	if(node == null){
    // 		return;
    // 	}

    // 	List<Integer> current;

    // 	int size = res.size();

    // 	if(size < depth){
    // 		current = new ArrayList<Integer>();
    // 		current.add(node.val);
    // 		res.add(current);
    // 	}else{ 
    // 		current = res.get(depth - 1);
    // 		current.add(node.val);
    // 	}

    // 	dfs(res, node.left, depth + 1);
    // 	dfs(res, node.right, depth + 1);
    // }

    // iteration
    public List<List<Integer>> levelOrder(TreeNode root) {
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

    		res.add(current);
    		current = new ArrayList<Integer>();
    	}

    	return res;

    }

}