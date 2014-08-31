// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

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
    	// solution that uses O(n) space : do a in-order traversal, store all the nodes in 
    	// a list, then checking which two nodes violate the bst property, keep their
    	// reference then swap the value.

	// this solution is dumb. it reassign all values of nodes in the tree.
    // public void recoverTree(TreeNode root) {
    // 	if(root == null) return;

    // 	Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
    // 	List<Integer> valQ = new ArrayList<Integer>();

    // 	inOrder(nodeQ, valQ, root);

    // 	Collections.sort(valQ);

    // 	for(int i = 0; i < valQ.size(); i++){
    // 		TreeNode node = nodeQ.poll();
    // 		node.val = valQ.get(i);
    // 	}
    	
    // }

    // public void inOrder(Queue<TreeNode> nodeQ, List<Integer> valQ, TreeNode node){
    // 	if(node == null) return;

    // 	inOrder(nodeQ, valQ, node.left);
    // 	nodeQ.add(node);
    // 	valQ.add(node.val);
    // 	inOrder(nodeQ, valQ, node.right);
    // }

	// O(n) space solution that detects one or two violation.   
	// though O(1) space solution using Morris traversal exists.
    public void recoverTree(TreeNode root) {
    	if(root == null) return;

    	Queue<TreeNode> queue = new LinkedList<TreeNode>();

    	inOrder(queue, root);
        // now queue is the in-order traversal of the binary tree.

        TreeNode v1L = null;
        TreeNode v1R = null;
        TreeNode v2 = null;
    	while(!queue.isEmpty()){
    		TreeNode first = queue.poll();
            // violation
			if(queue.peek() != null && first.val >= queue.peek().val){
                if(v1L == null){
                    v1L = first;
                    v1R = queue.peek();
                }else{
                    v2 = queue.peek();
                }
			}
    	}

        if(v2 != null){
            int temp = v1L.val;
            v1L.val = v2.val;
            v2.val = temp;
            return;
        }else{
            int temp = v1L.val;
            v1L.val = v1R.val;
            v1R.val = temp;
            return;
        }
    }

    public void inOrder(Queue<TreeNode> queue, TreeNode node){
    	if(node == null) return;

    	inOrder(queue, node.left);
    	queue.add(node);
    	inOrder(queue, node.right);
    }
}
