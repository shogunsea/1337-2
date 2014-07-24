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