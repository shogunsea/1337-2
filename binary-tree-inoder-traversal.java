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
    // threaded binary tree solution(morris traversal)
    // time : O(N), space : O(1)
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     if(root == null){
    //         return res;
    //     }
        
    //     TreeNode current = root, previous = null;
    //     while(current != null){
    //         if(current.left == null){
    //             res.add(current.val);
    //             previous = current;
    //             current= current.right;
    //         }else{
    //             TreeNode rightMost = current.left;
    //             while(rightMost.right != null && rightMost.right != current){
    //                 rightMost = rightMost.right;
    //             }
    //             if(rightMost.right == null){
    //                 rightMost.right = current;
    //                 previous = current;
    //                 current = current.left;
    //             }else{
    //                 res.add(current.val);
    //                 previous = current;
    //                 rightMost.right = null;
    //                 current = current.right;
    //             }
    //         }
    //     }
    //     return res;
    // }
    
    // recursive approach.
    // time: T(n) = 2T(n/2) + o(1) --> T(n) = O(n)
    //Space: O(logN) stack in memory.
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     dfsHelper(res, root);
    //     return res;
    // }
    
    // public void dfsHelper(List<Integer> res, TreeNode node){
    //     if(node == null){
    //         return;
    //     }
        
    //     dfsHelper(res, node.left);
    //     res.add(node.val);
    //     dfsHelper(res, node.right);
    // }
    
    // iteration solution using stack.
    // time O(n) space O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> inOrderStack = new Stack<TreeNode>();
        TreeNode current = root;
        
        while(!inOrderStack.isEmpty() || current != null){
            if(current != null){
                inOrderStack.push(current);
                current = current.left;
            }else{
                current = inOrderStack.pop();
                res.add(current.val);
                current = current.right;
            }
        }
        return res;
    }
}