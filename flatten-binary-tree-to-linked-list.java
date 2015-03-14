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
    // two apporaches:
    // 1.in-order traversal approach by using extra list.
    // 2.recursive approach: modify tree structrue recursively.
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        if(root.val % 2 == 0){
            method1(root);
        }else{
            method2(root);
        }
    }

    public void method1(TreeNode node){
        List<TreeNode> list = new ArrayList<TreeNode>();
        preOrder(node, list);

        for(int i = 0; i < list.size(); i++){
            TreeNode current = list.get(i);
            if(i != list.size() - 1){
                current.left = null;
                current.right  = list.get(i + 1);
            }
        }
    }

    public void preOrder(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }

        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public void method2(TreeNode node){
        if(node == null){
            return;
        }

        if(node.left != null){
            TreeNode left = node.left;
            TreeNode right = node.right;

            node.right = left;
            node.left = null;

            TreeNode rightMost = left;

            while(rightMost.right != null){
                rightMost = rightMost.right;
            }

            rightMost.right = right;
        }

        method2(node.right);
    }
}