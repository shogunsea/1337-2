// //Definition for binary tree
//  public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }
 
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       int iLen = inorder.length;
       int pLen = postorder.length;
       if(iLen != pLen){
           return null;
       }
       
       return helper(inorder, postorder, 0, iLen - 1, 0, pLen - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd){
        if(iStart > iEnd || pStart > pEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[pEnd]);
        int mid = 0;
        for(int i = iStart; i <= iEnd; i++){
            if(postorder[pEnd] == inorder[i]){
                mid = i;
                break;
            }
        }
        
        // root.left = helper(inorder, postorder, iStart, mid - 1, pStart, pStart + (mid - iStart) - 1);
        root.left = helper(inorder, postorder, iStart, mid - 1, pStart, pEnd - (iEnd - mid) - 1);
        root.right = helper(inorder, postorder, mid + 1, iEnd, pStart + (mid - iStart), pEnd - 1);
        return root;
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) {
            return null;
        }
        
        return buildHelper(inorder, postorder, 0, len - 1, 0, len - 1);
    }
    
    public TreeNode buildHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int posEnd) {
        if (posStart > posEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[posEnd]);
        int rootIndex = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[posEnd]) {
                rootIndex = i;
                break;
            }
        }
        
        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;
        
        root.left = buildHelper(inorder, postorder, inStart, rootIndex - 1, posStart, posStart + leftSize - 1);
        root.right = buildHelper(inorder, postorder, rootIndex + 1, inEnd, posEnd - rightSize, posEnd-1 );
        
        return root;
    }
}