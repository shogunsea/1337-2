// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

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
    public ListNode reverseBetween(ListNode head, int m, int n) {	
    	if(head == null || head.next == null || m == n) return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode runner = dummy;

    	for(int i = 0; i < m - 1; i++){
    		runner = runner.next;
    		if(runner == null) return dummy.next;
    	}

    	ListNode start = runner.next;
    	ListNode end = start;
    	for(int i = 0; i < (n - m); i++){
    		end = end.next;
    		if(end == null) return dummy.next;
    	}

    	runner.next = reverse(start, end);
    	return dummy.next;
    }

    public ListNode reverse(ListNode start, ListNode end){
    	ListNode finalEnd = end.next;
    	ListNode pre = start;
    	ListNode curr = start.next;

    	while(curr != finalEnd){
    		ListNode next = curr.next;
    		curr.next = pre;
    		pre = curr;
    		curr = next;
    	}
    	start.next = finalEnd;
    	return end;
    }
}