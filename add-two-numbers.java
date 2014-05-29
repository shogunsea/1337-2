// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 ==null){
        	return l1 == null? l2 : l1;
        }

        int carry = 0;
        int sum = 0;

        ListNode head = new ListNode(0);
        ListNode runner = head;

        while(l1 !=null || l2 !=null){
        	if(l1 == null){
        		sum = carry + l2.val;
        		l2 = l2.next;
        	}else if(l2 == null){
        		sum = carry + l1.val;
        		l1 = l1.next;
        	}else{
        		sum = carry + l1.val + l2.val;
        		l1 = l1.next;
        		l2 = l2.next;
        	}

        	carry = sum / 10;
    		sum = sum % 10;

    		runner.next = new ListNode(sum);
    		runner = runner.next;
        }

        if(carry == 1){
        	runner.next = new ListNode(carry);
        }

        return head.next;
    }
}