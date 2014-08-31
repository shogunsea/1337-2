// Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }

        int len = 0;

        ListNode runner = head;

        while(runner != null){
        	len++;
        	runner = runner.next;
        }

        runner = head;
        int mid = len /2 - 1;
        
        for(int i = 0; i < mid; i++){
            runner = runner.next;
        }
        
        ListNode rest = runner.next;
        runner.next = null;

        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(rest);

        ListNode resultHead = null, resultTail = null;

        while(firstHalf != null || secondHalf != null){
        	// firstHalf won't be null at first call.
        	if(firstHalf == null ){
        		resultTail.next = secondHalf;
        		resultTail = resultTail.next;
        		secondHalf = secondHalf.next;
        		continue;
        	}else if(secondHalf == null){
        		resultTail.next = firstHalf;
        		resultTail = resultTail.next;
        		firstHalf = firstHalf.next;
        		continue;
        	}

        	if(firstHalf.val < secondHalf.val){
        		if(resultHead == null){
        			resultHead = firstHalf;
        			resultTail = resultHead;
        			firstHalf = firstHalf.next;
        		}else{
        			resultTail.next = firstHalf;
        			resultTail = resultTail.next;
        			firstHalf = firstHalf.next;
        		}
        	}else{
        		if(resultHead == null){
        			resultHead = secondHalf;
        			resultTail = resultHead;
        			secondHalf = secondHalf.next;
        		}else{
        			resultTail.next = secondHalf;
        			resultTail = resultTail.next;
        			secondHalf = secondHalf.next;
	        	}
	        }
    	}
    	return resultHead;
	}
}

