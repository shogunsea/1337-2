// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	// simple idea: create left and right sublist, iterate through input list and append each node
	// to list where it should be.
	// space: O(n) time:O(n)
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null) return head;

    	ListNode leftHead =new ListNode(0);
    	ListNode leftTail = leftHead;
    	ListNode rightHead = new ListNode(0);
    	ListNode rightTail = rightHead;
    	ListNode runner = head;

    	while(runner != null){
    	    ListNode next = runner.next;
    		if(runner.val < x){
    			leftTail.next = runner;
    			leftTail = leftTail.next;
    		}else{
    			rightTail.next = runner;
    			rightTail = rightTail.next;
    		}
            runner.next = null;
    		runner = next;
    	}

    	leftTail.next = rightHead.next;

    	return leftHead.next;
    }
}