// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;

        if(len == 0){
            return null;
        }

        TreeNode root = convert(num, 0 , len - 1);
        return root;
    }

    public TreeNode convert(int[] num, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convert(num, start, mid - 1);
        root.right = convert(num, mid + 1, end);
        return root;
    }
}