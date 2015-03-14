// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null || head.next == null) return head;

        ListNode fake = new ListNode(0);
        fake.next = head;

        ListNode runner = fake;

        while(runner != null){
        	ListNode tmpRunner = runner;
        	int counter = 0;
        	while(counter < k && tmpRunner != null){
        		counter++;
        		tmpRunner = tmpRunner.next;
        	}
        	if(counter != k || tmpRunner == null) break;

        	ListNode start = runner.next;

        	runner.next = reverse(start, tmpRunner);

        	for(int i = 0; i < k; i++){
        		runner = runner.next;
        	}
        }

        return fake.next;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode runner = dummy;
        
        while(runner != null && runner.next != null){
            runner = reverse(runner, k);
        }
        
        return dummy.next;
    }
    
    // should return the next previous node.
    public ListNode reverse(ListNode previous, int k){
        ListNode runner = previous;
        int counter = 0;
        while(counter <= k && runner != null){
            runner = runner.next;
            counter++;
        }
        
        if(counter <= k){
            // sub list is shorter than k.
            return null;
        }
        
        ListNode current = previous.next;
        ListNode next;
        while(k > 1){
            next = current.next;
            current.next = next.next;
            next.next = previous.next;
            previous.next = next;
            k--;
        }
        
        return current;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode runner = dummy;

        while (runner != null) {
            ListNode start = runner;
            int count = k;

            while (count != 0 && runner != null) {
                runner = runner.next;
                count--;
            }

            if (runner != null) {
                ListNode tail = runner.next;
                runner = reverse(start, tail);
            }
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode start = head.next;
        ListNode runner = start;
        ListNode previous = null;

        while (runner != tail) {
            ListNode next = runner.next;
            runner.next = previous;
            previous = runner;
            runner = next;
        }

        head.next = previous;
        start.next = tail;

        return start;
    }
}