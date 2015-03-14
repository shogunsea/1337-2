// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) return head;

    	ListNode fast = head;
    	ListNode slow = null;

    	int step = n - 1;

    	while(step >= 0){
    		fast = fast.next;
    		step--;
    	}
// {1,2}  1
// {1,2}  2
    	while(fast != null){
    		fast = fast.next;
    		// if(fast != null){
    			if(slow == null){
    				slow = head;
    			}else{
	    			slow = slow.next;
    			}
    		// }
    	}

    	if( slow == null ){
    		return head.next;
    	}

    	slow.next = slow.next.next;

    	return head;
    }
}


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = n;

        while (count != 0 && fast != null) {
            fast = fast.next;
            count--;
        }

        // if (fast == null) {
        //     // given n will always be valid... so we should not worry about this condition? try to test it.
        //     return dummy.next;

        // }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}