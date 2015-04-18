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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        
        helper(res, root, 0);
        
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
    //     1
    //    / \
    //   2   3
    //  /
    // 4
        
        if (res.size() <= level) {
            res.add(node.val);
        }
        
        if (node.right != null) {
            helper(res, node.right, level + 1);
        } 
        if (node.left != null) {
            helper(res, node.left, level + 1);
        }
    }
}