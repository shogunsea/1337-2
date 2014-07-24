// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Follow up:
// Can you solve it without using extra space?

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null){
        	fast = fast.next;
        	slow = slow.next;

        	if(fast != null){
        		fast = fast.next;
        		if(fast == slow){
        			fast = head;

        			while(fast != slow){
        				fast = fast.next;
        				slow = slow.next;
        			}

        			return fast;
        		}
        	}
        }

        return null;
    }
}