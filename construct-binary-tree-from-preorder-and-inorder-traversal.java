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
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        return buildHelper(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode buildHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;
        // inorder index range is easy: left : (inStart, rootIndex - 1),  right: (rootIndex + 1, inEnd)
        // preorder needs calculation. left: (preStart + 1, preStart + leftSize), right : (preEnd - rightSize + 1, preEnd)
        root.left = buildHelper(preorder, inorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = buildHelper(preorder, inorder, preEnd - rightSize + 1, preEnd, rootIndex + 1, inEnd);

        return root;
    }
}


