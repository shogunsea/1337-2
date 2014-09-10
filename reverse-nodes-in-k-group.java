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