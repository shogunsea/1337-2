// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?

public class Solution{
	// public boolean hasCycle(ListNode node){
	// 	if(node == null){
	// 		return false;
	// 	}

	// 	HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();

	// 	ListNode runner = node;

	// 	while(runner != null){
	// 		if(map.containsKey(runner)){
	// 			return true;
	// 		}
	// 		map.put(runner, 1);
	// 		runner = runner.next;
	// 	}

	// 	return false;
	// }

	public boolean hasCycle(ListNode node){
		if(node == null){
			return false;
		}

		ListNode fast = node;
		ListNode slow = node;

		while(fast !=null){
			fast = fast.next;
			slow = slow.next;
			if(fast!=null){
				fast = fast.next;
				if(fast == slow){
					return true;
				}
			}
		}

		return false;
	}
}