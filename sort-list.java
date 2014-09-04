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
    // sort the list by k steps each time, k starts from 2, each time increase by 
    // 2 times, i.e. k = 2, 4, 8, etc. 
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        int step = 2;
        while(true){
            int run = 0;

            ListNode start = dummy;

            while(start != null && start.next != null){
                start = sortSubList(start, step);
                run++;
            }

            if(run <= 1){
                break;
            }

            step *= 2;
        }

        return dummy.next;
    }

    public ListNode sortSubList(ListNode node, int subLen){
        if(node == null || node.next == null){
            return null;
        }

        ListNode leftStart = node.next;
        ListNode leftEnd = move(leftStart, subLen / 2 - 1);
        
        // for(int i = 0; i < subLen / 2 - 1; i++){
        //     leftEnd = leftEnd == null? leftEnd : leftEnd.next; 
        // }

        if(leftEnd == null){
            return null;
        }

        ListNode rightStart = leftEnd.next;
        leftEnd.next = null;
        ListNode rightEnd = move(rightStart, subLen / 2 - 1);

        // if(rightStart == null){
        //     return null;
        // }

        // for(int j = 0; j < subLen / 2 - 1; j++){
        //     rightEnd = rightEnd == null? rightEnd : rightEnd.next;
        // }

        ListNode endNode = rightEnd == null? rightEnd : rightEnd.next;
        
        if(endNode != null){
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
































        