// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
        	return null;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode prev = tempHead;
        ListNode a = head;
        ListNode b = head.next;

		while(a != null && b != null){
			prev.next = b;
			a.next = b.next;
			b.next = a;
			prev = a;
			a = a.next;
			if(a == null){
				break;
			}			
			b = a.next;
		}

		return tempHead.next;
    }
}