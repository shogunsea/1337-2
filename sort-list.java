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
    // recursion : O(nlogn) time, O(logn) stack allocation. each stack creates O(1)
    // local variables, so space is also O(logn).
    
    // public ListNode sortList(ListNode head) {
    //     if(head == null || head.next == null){
    //         return head;
    //     }

    //     // Use fast and slow pointer to get the middle element. Note that slow is
    //     // one node ahead of the mid element. Where else this technique is used.? 
    //     // see reorder-list.java
        
    //     // two approach of finding middle element, same idea with
    //     // minor difference:

    //     // Method A:
    //     // ListNode fast = head;
    //     // ListNode slow = head;

    //     // while(fast.next != null && fast.next.next != null){
    //     //     fast = fast.next.next;
    //     //     slow = slow.next;
    //     // }

    //     // Method B:
    //     ListNode fast = head.next.next;
    //     ListNode slow = head;

    //     while(fast != null && fast.next != null){
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }

    //     // recursively sort the right half of the list.
    //     ListNode right = sortList(slow.next);
    //     // split the left and right sublists.
    //     slow.next = null;
    //     // sort the left half.
    //     ListNode left = sortList(head);
    //     // merge the two sublists.
    //     return merge(left, right);
    // }

    // public ListNode merge(ListNode left, ListNode right){
    //     ListNode dummy = new ListNode(Integer.MIN_VALUE);
    //     ListNode runner = dummy;
    //     while(left != null && right != null){
    //         if(left.val < right.val){
    //             runner.next = left;
    //             left = left.next;
    //             runner = runner.next;
    //         }else{
    //             runner.next = right;
    //             right = right.next;
    //             runner = runner.next;
    //         }
    //     }

    //     if(left != null){
    //         runner.next = left;
    //     }else if(right != null){
    //         runner.next = right;
    //     }

    //     return dummy.next;
    // }


    // iterative solution: the bottom-up fashion of merge sort.
    // sort the list by k steps each time, k starts from 2, each time double k's
    // value, i.e. k = 2, 4, 8, etc. For each step value k, scan the list from 
    // head then sort the k nodes starting from current starting node, during
    // the reordering process remember to remain the list integrity by recovering
    // connection to original ending node. outer while loop takes O(logN), inner
    // takes O(n), total O(nlogn) time. Since this is iteration, local variable and
    // stack allocation is O(1), so the space complexity is also O(1).
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        int step = 2;
        while(true){
            int run = 0;

            // each iteration starts from the first node.
            ListNode start = dummy;

            // null list or sub list with single node is alreay sorted.
            while(start != null && start.next != null){
                start = sortSubList(start, step);
                run++;
            }

            // when the list is fully sorted, start will point to last
            // element after first iteration.
            if(run <= 1){
                break;
            }

            step *= 2;
        }

        return dummy.next;
    }

    public ListNode sortSubList(ListNode node, int subLen){
        // should not process null node.
        if(node == null){
            return null;
        }

        ListNode leftStart = node.next;
        ListNode leftEnd = move(leftStart, subLen / 2 - 1);
        
        // sublist length smaller than current step, invalid.
        // since left half should be valid and none empty,
        // while right half could be empty.
        if(leftEnd == null){
            return null;
        }

        ListNode rightStart = leftEnd.next;
        // split sublists to avoid infinite loop.
        leftEnd.next = null;
        // right half could be empty.
        ListNode rightEnd = move(rightStart, subLen / 2 - 1);
        ListNode endNode = rightEnd == null? rightEnd : rightEnd.next;
        
        if(endNode != null){
            // if right half is not the end of the original list,
            // should split it from the rest of the original list.
            rightEnd.next = null;
        }

        while(leftStart != null || rightStart != null){
            if(rightStart == null || (leftStart != null && leftStart.val < rightStart.val)){
                node.next = leftStart;
                leftStart = leftStart.next;
                node = node.next;
            }else{
                node.next = rightStart;
                rightStart = rightStart.next;
                node = node.next;
            }
        }
        // recover the connection to the rest of input list.
        node.next = endNode;

        return node;
    }

    public ListNode move(ListNode node, int step){
        while(node != null && step-- > 0){
            node = node.next;
        }

        return node;
    }
}
