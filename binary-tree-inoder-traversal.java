// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	if(root == null){
    		return	list;
    	}
    	Set<TreeNode> visited = new HashSet<TreeNode>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode tmp = null;
    	stack.push(root);
    	visited.add(root);

    	while(!stack.isEmpty()){
    		if(stack.peek().left!=null){
    			if(visited.contains(stack.peek().left)){
    				tmp = stack.pop();
    				list.add(tmp.val);
    				visited.add(tmp);
    				if(tmp.right != null){
	    				stack.push(tmp.right); 
    				}
    			}else{
	    			stack.push(stack.peek().left);
    			}
    		}else{
    			tmp = stack.pop();
    			visited.add(tmp);
    			list.add(tmp.val);
    			if(tmp.right!=null){
    			    stack.push(tmp.right);
    			}
    		}
    	}

 //    	return list;
	// }

	// public ArrayList<Integer> inorderTraversal(TreeNode root){
	// 	ArrayList<Integer> list = new ArrayList<Integer>();

	// 	if(root == null){
	// 		return list;
	// 	}

	// 	Stack<TreeNode> stack = new Stack<TreeNode>();
	// 	TreeNode current = root;

	// 	while(!stack.isEmpty() || current != null){
	// 		if(current!=null){
	// 			stack.push(current);
	// 			current = current.left;
	// 		}else{
	// 			current = stack.pop();
	// 			list.add(current.val);
	// 			current = current.right;
	// 		}
	// 	}

	// 	return list;
	// }
}






