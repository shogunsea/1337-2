// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
        	return null;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode prev = tempHead;
        ListNode a = head;
        ListNode b = head.next;

		while(a != null && b != null){
			prev.next = b;
			a.next = b.next;
			b.next = a;
			prev = a;
			a = a.next;
			if(a == null){
				break;
			}			
			b = a.next;
		}

		return tempHead.next;
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode current = head;
        ListNode pre = dummy;

        while (current != null && current.next != null) {
            ListNode next = current.next;
            ListNode nextCurrent = next.next;
            pre.next = next;
            next.next = current;
            current.next = nextCurrent;
            pre = current;
            current = nextCurrent;
        }

        return dummy.next;
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }

        ListNode evenDummy = new ListNode(1);
        ListNode oddDummy = new ListNode(2);
        ListNode runner = head;
        int counter = 0;
        ListNode evenRunner = evenDummy;
        ListNode oddRunner = oddDummy;

        while (runner != null) {
            ListNode next = runner.next;
            if (counter % 2 == 0) {
                evenRunner.next = runner;
                evenRunner = evenRunner.next;
                evenRunner.next = null;
            } else {
                oddRunner.next = runner;
                oddRunner = oddRunner.next;
                oddRunner.next = null;
            }

            runner = next;
            counter++;
        }  

        ListNode mergeDummy = new ListNode(3);
        ListNode mergeRunner = mergeDummy;
        evenRunner = evenDummy.next;
        oddRunner = oddDummy.next;

        while (evenRunner != null || oddRunner != null) {
            if (oddRunner != null) {
                mergeRunner.next = oddRunner;
                oddRunner = oddRunner.next;
                mergeRunner = mergeRunner.next;
                mergeRunner.next = null;
            }
            if (evenRunner != null) {
                mergeRunner.next = evenRunner;
                evenRunner = evenRunner.next;
                mergeRunner = mergeRunner.next;
                mergeRunner.next = null;
            }
        }

        return mergeDummy.next;

    }
}



