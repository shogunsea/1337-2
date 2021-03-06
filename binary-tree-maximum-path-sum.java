public class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;

        dfs(root, res);

        return res[0];
    }

    public int dfs(TreeNode node, int[] res){
        if(node == null) return 0;

        int left = dfs(node.left, res) ;
        int right = dfs(node.right, res) ;

        // currentMax candidates(open path not closed, path should be able to extend): 
        //  1. node; 2. node + single child.
        int currentMax = Math.max(node.val, left > right? left + node.val : right + node.val);

        // globalMax candidates:(both open&closed path should be considered):
        // 1.stored max; 2.node; 3.node + single child; 4.node + both children.
    //  int globalMax = Math.max(res[0], Math.max(node.val, Math.max(left + node.val + right, left > right? node.val + left : node.val + right)));
        int globalMax = Math.max(node.val + left + right, currentMax);

        res[0] = globalMax > res[0]? globalMax : res[0];

        return currentMax;
    }
}