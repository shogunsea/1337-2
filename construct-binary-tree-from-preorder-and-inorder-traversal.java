// Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	// some key ideas are that: 
    	// 1.first element of preorder is the root node.
    	// 2.if found the root node's index in the in-order array, 
    	//   then indexes smaller than it represents left sub-tree, indexes larger than the 
    	//   root index represent the right sub-tree.
    	// 3. each iteration we need to locate the root's index in in-order array.
    	int pLen = preorder.length;
    	int iLen = inorder.length;
    	if(pLen != iLen || pLen == 0) return null;

    	return helper(preorder, inorder, 0, pLen - 1, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int iStart, int iEnd, int pIndex){
    	if(iStart > iEnd) return null;
    	if(iStart == iEnd) return new TreeNode(inorder[iStart]);

    	int mid = 0;

    	for(int i = iStart; i <= iEnd; i++){
    		if(preorder[pIndex] == inorder[i]){
    			mid = i;
    			break;
    		}
    	}

    	TreeNode node = new TreeNode(inorder[mid]);
    	// why pIndex + 1: since in the preorder traversal, next element is the root of current
    	// element's left subtree.
    	node.left = helper(preorder, inorder, iStart, mid - 1, pIndex + 1);
    	// why mid - istart + 1: it represents all the elements covered so far, which are all
    	// less then the root node's value.
    	node.right = helper(preorder, inorder, mid + 1, iEnd, pIndex + (mid - iStart + 1));

    	return node;
    }
}
