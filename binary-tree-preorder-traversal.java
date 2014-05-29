// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

// Note: Recursive solution is trivial, could you do it iteratively?

public class Solution{
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> list = new ArrayList<Integer>();

		if(root == null){
			return list;
		}

		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);

		while(!st.isEmpty()){
			TreeNode tmp = st.pop();

			if(tmp!=null){
				list.add(tmp.val);
				st.push(tmp.right);
				st.push(tmp.left);
			}
		}

		return list;
	} 
}