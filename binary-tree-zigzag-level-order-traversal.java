    			
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
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
	// key problem is figure out how to identify even and odd level so that decide which order, left to right / right to left,
	// we should use to traverse the current level.

	// recursive solution: pass down level index, odd level: insert at 0, even append at last. or vice versa.
	// 		each recursion check if current level has already been visited or not.
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> result = new ArrayList<List<Integer>>();
    //     if(root == null) return result;

    //     dfs(result, root, 0);

    //     return result;
    // }

    // public void dfs(List<List<Integer>> result, TreeNode node, int level){
    // 	if(node == null) return;

    // 	List<Integer> tempList;

    // 	if(result.size() > level){
    // 		// current level has already been visited so far.
    // 		tempList = result.get(level);
    // 	}else{
    // 		tempList = new ArrayList<Integer>();
    // 		result.add(tempList);
    // 	}
    // 	// check if current level is odd or even.
    // 	// even: left -> right
    // 	// odd : right -> left
    // 	if(level % 2 == 0){
    // 		tempList.add(node.val);
    // 	}else{
    // 		if(tempList.size() == 0){
    // 			tempList.add(node.val);
    // 		}else{
    // 			tempList.add(0, node.val);
    // 		}
    // 	}

    // 	dfs(result, node.left, level + 1);
    // 	dfs(result, node.right, level + 1);
    // }

    // iterative solution.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null) return result;
    	Stack<TreeNode> queue = new Stack<TreeNode>();
    	queue.push(root);
    	int level = 0;

    	while(!queue.isEmpty()){
    		level++;
    		List<Integer> list = new ArrayList<Integer>();
    		for(TreeNode node : queue){
    			list.add(node.val);
    		}
    		result.add(list);

    		Stack<TreeNode> tempQ = new Stack<TreeNode>();
    		while(!queue.isEmpty()){
    			TreeNode node = queue.pop();
    			if(level % 2 == 0){
    				if(node.left != null){
    					tempQ.push(node.left);
    				}
    				if(node.right != null){
    					tempQ.push(node.right);
    				}
    			}else{
    				if(node.right != null){
    					tempQ.push(node.right);
    				}
    				if(node.left != null){
    					tempQ.push(node.left);
    				}
    			}
    		}
    		queue = tempQ;
    	}

    	return result;
    }
}