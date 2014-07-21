// Sort a linked list using insertion sort.

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }

        ListNode fk = new ListNode(Integer.MIN_VALUE);
        ListNode runner = head;
        ListNode previous, next;

        while(runner != null){
        	previous = getPrevious(fk, runner);
        	next = runner.next;
        	runner.next = previous.next;
        	previous.next = runner;
        	runner = next;
        }

        return fk.next;
    }

    public ListNode getPrevious(ListNode fk, ListNode node){
    	ListNode previous = null;
    	ListNode runner = fk;
    	while(runner != null && runner.val <= node.val){
    		previous = runner;
    		runner = runner.next;
    	}

    	return previous;
    }
}