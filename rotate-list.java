// Given a list, rotate the list to the right by k places, where k is non-negative.

// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

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

	// My own solution.. that can pass 158 / 229 test cases, got stuck in {1,2}, 3, 
	// where k is larger than the list size. Figured that this is because 
	// didnt understand the meaning of rotate quite well. 
	// See the following example:
	// Given [0,1,2], rotate 1 steps to the right -> [2,0,1].
	// Given [0,1,2], rotate 2 steps to the right -> [1,2,0].
	// Given [0,1,2], rotate 3 steps to the right -> [0,1,2].
	// Given [0,1,2], rotate 4 steps to the right -> [2,0,1].
	// So, no matter how big K, the number of steps is, the 
	//result is always the same as rotating K % n steps to the right.
	// See second solution that implements this idea.

	// Solution one : 158 / 229 test cases past.
    // public ListNode rotateRight(ListNode head, int n) {
    // 	if(head == null || n == 0) return head;

    // 	ListNode fast = head;
    // 	ListNode slow = null;
    // 	int counter = 0;

    // 	while(fast != null ){
    // 		if(slow != null){
    // 			slow = slow.next;
    // 		}

    // 		if(counter == n){
    // 			slow = head;
    // 		}

    // 		counter++;
    // 		fast = fast.next;
    // 	}

    // 	// n is greater than or equal to the length of the list;
    // 	if(counter < n || slow == null ) return head;

    // 	ListNode newHead = slow.next;
    // 	ListNode runner = newHead;

    // 	while(runner.next != null ){
    // 		runner = runner.next;
    // 	}

    // 	ListNode newTail = runner;
    // 	newTail.next = head;
    // 	slow.next = null;

    // 	return newHead;
    // }

	// The other approach.
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null || n == 0) return head;

    	int len = 0;
    	ListNode runner = head;
    	while(runner != null){
    		runner = runner.next;
    		len++;
    	}

    	// First get the length of the input list,
    	// if steps n is multiple of len then we do nothing.
    	// other wise the modulo is the real step we 
    	// need to perform on the list.
    	int step = n % len;

    	if(step == 0) return head;

    	runner = head;

    	// Move the pointer to the step nodes ahead
    	// of the end of the list.
    	for(int i = 1; i < len - step; i++){
    		runner = runner.next;
    	}

    	// Get the end of the list and chage the node
    	// reference accordingly.
    	ListNode newHead = runner.next;
    	ListNode newTail = newHead;
    	while(newTail.next != null){
    		newTail = newTail.next;
    	}

    	newTail.next = head;
    	runner.next = null;

    	return newHead;
    }
}