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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        
        ListNode previous = dummy;

        while(previous.next != null){
        	ListNode current = previous.next;

        	while(current.next != null && current.val == current.next.val){
        		current = current.next;
        	}

        	if(current != previous.next){
        		previous.next = current.next;
        	}else{
        		previous = current;
        	}
        }

        return dummy.next;

    }
}