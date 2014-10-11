public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode parent = root;
        
        // check initial node at current level is valid or not.
        while (parent != null) {
            TreeLinkNode nextLevel = null;
            TreeLinkNode left = null;
            
            // iterate over current level.            
            while (parent != null) {
                if (parent.left != null) {
                    // if parent is the first node at this level, left should be null,
                    // no nodes to be connected, and nextLevel should be parent.left
                    if (left == null) {
                        nextLevel = parent.left;
                    } else {
                        // if left!=null, means parent is not the first node at this level,
                        // left is left/right node of previous sibling of parent.
                        left.next = parent.left;
                    }
                    left = parent.left;
                }
                
                if (parent.right != null) {
                    // if parent is the first node at this level and has no left child, 
                    // right child should be set as the nextLevel.
                    if (left == null) {
                        nextLevel = parent.right;
                    } else {
                        // if parent has left child, or parent has no left child but is not 
                        // the first node at this level.
                        left.next = parent.right;
                    }
                    left = parent.right;
                }
                parent = parent.next;
            }
            parent = nextLevel;
        }
    }
}