// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

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
	// Two approach. Divid and conquer | Using priority queue.

	// // Divide&Conquer approach.
 //    public ListNode mergeKLists(List<ListNode> lists) {
	// 	if(lists == null || lists.size() == 0) return null;

	// 	int size = lists.size();

	// 	// Continously split input lists into two halves until
	// 	// current range only contains one node, then merge cooresponding
	// 	// two nodes using merge function.
	// 	return divideHelper(lists, 0, size - 1);   
 //    }

 //    private ListNode divideHelper(List<ListNode> lists, int left, int right){
 //    	if(left < right){
 //    		int mid = (left + right) / 2;
 //    		// keep spliting until the range contains only one node.
 //    		return merge(divideHelper(lists, left, mid), divideHelper(lists, mid + 1, right));
 //    	}

 //    	return lists.get(right);
 //    }

 //    // Same logic as used in the problem 'merge two sorted lists'
 //    private ListNode merge(ListNode node1, ListNode node2){
 //    	ListNode node = new ListNode(-1);

 //    	ListNode runner = node;

 //    	while(node1 != null || node2 != null){
 //    		if(node1 == null){
 //    			runner.next = node2;
 //    			runner = runner.next;
 //    			node2 = node2.next;
 //    			continue;
 //    		}

 //    		if(node2 == null){
 //    			runner.next = node1;
 //    			runner = runner.next;
 //    			node1 = node1.next;
 //    			continue;
 //    		}

 //    		if(node1.val < node2.val){
 //    			runner.next = node1;
 //    			runner = runner.next;
 //    			node1 = node1.next;
 //    		}else{
 //    			runner.next = node2;
 //    			runner = runner.next;
 //    			node2 = node2.next;
 //    		}
 //    	}

 //    	return node.next;
 //    }


	// Using priority Queue:
	// The idea is that, assume we have k list headers in the input lists, 
	// maintain a priority queue of size k, then we iterate through all the nodes 
	// in the queue: each time dequeue one node, add its next node to the queue.
	// since all k lists are sorted, each time we maintain its prority takes O(logk) time,
	// assume we have k * n nodes, then total time is : O(nklogk), space: O(k)
	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0) return null;

		PriorityQueue<ListNode> queue = new PriorityQueue(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                if(node1.val < node2.val){
                    return 1;
                }else if(node1.val == node2.val){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

		for(ListNode node : lists){
			if(node != null){
				queue.add(node);
			}
		}

		ListNode dummy = new ListNode(1);
		ListNode runner = dummy;

		while(!queue.isEmpty()){
			ListNode current = queue.poll();
			runner.next = current;
			runner = runner.next;

			if(current.next != null){
				queue.add(current.next);
			}
		}

		return dummy.next;
	}
}

















