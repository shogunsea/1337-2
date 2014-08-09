// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6


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
  // recursive approach, kind of in-place
    // public void flatten(TreeNode root) {
    //     if(root == null) return;

    //     TreeNode left = root.left;
    //     TreeNode right = root.right;

    //     if(left != null){
    //       root.right = left;
    //       root.left = null;
    //       TreeNode rightMostOnLeftTree = left;

    //       while(rightMostOnLeftTree.right != null){
    //         rightMostOnLeftTree = rightMostOnLeftTree.right;
    //       }

    //       rightMostOnLeftTree.right = right;
    //     }

    //     flatten(root.right);
    // }

  // in-order traversal approach. need extra list buffer.
    public void flatten(TreeNode root) {
        if(root == null) return;

        List<TreeNode> list = new ArrayList<TreeNode>();

        inOrder(list, root);

        for(int i = 0; i < list.size() - 1; i++){
            TreeNode current = list.get(i);
            current.left = null;
            current.right = list.get(i + 1);
        }
    }

    public void inOrder(List<TreeNode> list, TreeNode node){
      if(node == null) return;

      list.add(node);
      inOrder(list, node.left);
      inOrder(list, node.right);
    }

}
