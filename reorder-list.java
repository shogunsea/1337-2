public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
        	return;
        }

        // find one node before mid, cut into two half, reverse second half, then append one by one
        ListNode runner = head;
        int len = 0;

        while(runner != null){
        	runner = runner.next;
        	len++;
        }

        int mid = len / 2;
        int counter = 0;
        runner = head;

        while(counter != mid - 1){
        	runner = runner.next;
        }

        ListNode secondHalf = runner.next;
        runner.next = null;

        ListNode current = secondHalf;
        ListNode previous = null;

        while(current != null){
        	ListNode tempNext = current.next;
        	current.next = previous;
        	previous = current;
        	current = tempNext;
        }

        ListNode tailRunner = previous;
        ListNode headRunner = head;


        while(tailRunner != null){
        	ListNode tempHeadNext = headRunner.next;
        	headRunner.next = tailRunner;
        	headRunner = tempHeadNext;
        	ListNode tempTailNext = tailRunner.next;
        	tailRunner.next = headRunner;
        	tailRunner = tempTailNext;
        }
    }
}