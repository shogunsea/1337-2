// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [3,2,1].

// Note: Recursive solution is trivial, could you do it iteratively?

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(root == null) return	result;

    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<Integer> resultStack = new Stack<Integer>();
    	stack.push(root);

    	while(!stack.isEmpty()){
    		TreeNode currentNode = stack.pop();
    		if(currentNode!=null){
				resultStack.push(currentNode.val);
				stack.push(currentNode.left);
				stack.push(currentNode.right); 			
    		}
    	}

    	while(!resultStack.isEmpty()){
    		result.add(resultStack.pop());
    	}

    	return result;
    }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null){
    //     	return result;
    //     }

    //     recurHelper(root, result);

    //     return result;
    // }

    // public void recurHelper(TreeNode node, List<Integer> result){
    // 	if(node == null) return;

    // 	recurHelper(node.left, result);
    // 	recurHelper(node.right, result);
    // 	result.add(node.val);
    // }
}