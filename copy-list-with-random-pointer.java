// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null) return head;

    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode runner = head;

    	while(runner != null){
    		RandomListNode copy = new RandomListNode(runner.label);
    		map.put(runner, copy);
    		runner = runner.next;
    	}    

    	runner = head;

    	while(runner != null){
    		map.get(runner).next = map.get(runner.next);
    		map.get(runner).random = map.get(runner.random);
    		runner = runner.next;
    	}

    	return map.get(head);
    }
}

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // solution using constant space
        // the idea is that: interleaving original list by inserting
        // copied nodes into it during the first iteration,
        // then go through the list for second time, update the random
        // pointer
        // finally iterate the list for third time to revert back original
        // list and generate the new copied one.
        if (head == null) {
            return head;
        }
        
        RandomListNode runner = head;
        // insert copied nodes into list
        while (runner != null) {
            RandomListNode copied = new RandomListNode(runner.label);
            RandomListNode next = runner.next;
            runner.next = copied;
            copied.next = next;
            runner = next;
        }
        // update random pointer
        runner = head;
        RandomListNode copiedRunner = runner.next;
        while (runner != null) {
            if (runner.random != null) {
                copiedRunner.random = runner.random.next;
            }
            runner = copiedRunner.next;
            if (runner != null) {
                copiedRunner = runner.next;
            }
        }

        RandomListNode copiedHead = head.next;
        runner = head;
        copiedRunner = copiedHead;
        // revert back
        while (runner != null) {
            runner.next = copiedRunner.next;
            runner = runner.next;
            if (runner != null) {
                copiedRunner.next = runner.next;
                copiedRunner = copiedRunner.next;
            }
        }

        return copiedHead;
    }
}
