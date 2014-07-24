// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

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
	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode node, int sum){
		if(node == null) return 0;

		sum = sum * 10 + node.val; 

		if(node.left == null && node.right == null){
			return sum;
		}

		return dfs(node.left, sum) + dfs(node.right, sum);
	}
    // public int sumNumbers(TreeNode root) {
    // 	if(root == null) return 0;

    // 	List<List<Integer>> list = new ArrayList<List<Integer>>();
    //     List<Integer> tempList = new ArrayList<Integer>();
    //     // List<Integer> result
    //     int sum = 0;

    //     dfs(list, tempList, root);

    //     tempList = new ArrayList<Integer>();

    //     for(List<Integer> l : list){
    //     	int num = 0;
    //     	for(int i : l){
    //     		num += num*10 + i;
    //     	}
    //     	tempList.add(num);
    //     }

    //     for(int i : tempList){
    //     	sum += i;
    //     }

    //     return sum;
    // }

    // public void dfs(List<List<Integer>> list, List<Integer> tempList, TreeNode node){
    // 	tempList.add(node.val);

    // 	if(node.left == null && node.right == null){
    // 		List<Integer> match = new ArrayList<Integer>(tempList);
    // 		tempList.remove(tempList.size() - 1);
    // 		list.add(match);
    // 		return;
    // 	}

    // 	if(node.left != null){
    // 		dfs(list, tempList, node.left);
    // 	}

    // 	if(node.right != null){
    // 		dfs(list, tempList, node.right);
    // 	}
    // }
}