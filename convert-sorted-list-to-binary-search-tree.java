// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
        	return null;
        }

        int len = 0;

        ListNode runner = head;

        while(runner != null){
        	len++;
        	runner = runner.next;
        }

        ListNode[] list = {head};

        return inOrder(list, 0, len - 1);
    }

    public TreeNode inOrder(ListNode[] list, int start, int end){
    	if(start > end){
    		return null;
    	}

    	int mid = (start + end) / 2;
    	TreeNode left = inOrder(list, start, mid - 1);
    	TreeNode root = new TreeNode(list[0]);
    	list[0] = list[0].next;
    	TreeNode right = inOrder(list, mid + 1, end);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}















