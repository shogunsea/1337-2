// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	// similar to the solution in the preorder one, this time
    	// in the postorder, last element always represent the root node.
    	int iLen = inorder.length;
    	int pLen = postorder.length;
    	if(iLen != pLen || iLen == 0) return null;

    	return helper(inorder, postorder, 0, iLen - 1, pLen - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int iStart, int iEnd, int pIndex){
    	if(iStart > iEnd) return null;
    	if(iStart == iEnd) return new TreeNode(inorder[iStart]);

    	int mid = 0;

    	for(int i = iStart; i <= iEnd; i++){
    		if(postorder[pIndex] == inorder[i]){
    			mid = i;
    			break;
    		}
    	}

    	TreeNode node = new TreeNode(inorder[mid]);
    	node.left = helper(inorder, postorder, iStart, mid - 1, pIndex - (iEnd - mid + 1));
    	node.right = helper(inorder, postorder, mid + 1, iEnd, pIndex - 1);

    	return node;
    }
}
















