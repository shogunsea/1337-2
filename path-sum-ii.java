// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 return [ [5,4,11,2], [5,8,4,5] ]



// Sum = 22					

//			5 
//		   / \
//		  4   8 
//		 /   / \ 
//		11  13  4 
//	   / \     / \ 
//	  7   2   5   1 


public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }

        List<Integer> sols = new ArrayList<Integer>();

        dfs(result, sols, root, sum);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> sols, TreeNode node, int num){
        if(node == null) return;

        num -= node.val;

        if(node.left == null && node.right == null){
            if(num == 0){
                sols.add(node.val);
                result.add(new ArrayList<Integer>(sols));
                sols.remove(sols.size() - 1);
            }
            return;
        }

        sols.add(node.val);
        dfs(result, sols, node.left, num);
        dfs(result, sols, node.right, num);
        sols.remove(sols.size() - 1);
    }
}