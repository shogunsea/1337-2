// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

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
 		ListNode tmp = new ListNode(0);
 		tmp.next = head;
 		ListNode runner = tmp.next;

 		while(runner != null && runner.next != null){
 			if(runner.val == runner.next.val){
 				runner.next= runner.next.next;
 			}else{
	 			runner = runner.next;
 			}
 		}     

 		return tmp.next;  
    }
}