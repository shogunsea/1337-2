// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */


// Four approaches:{
//     1.Iteration:{
//         1.Queue:{
//             1. Make use of queue properties;
//             2.Queue w/o queue properties but node reference
//         }
//         2.Node references in while loop.
//     }
//     2.Recursion:{
//         1.Make use of next pointer.
//     }
// }


public class Solution {
    // public void connect(TreeLinkNode root) {
    //     if(root == null){
    //         return;
    //     }

    //     LinkedList<TreeLinkNode> previous = new LinkedList<TreeLinkNode>();   
    //     LinkedList<TreeLinkNode> current = new LinkedList<TreeLinkNode>();   
    //     previous.push(root);

    //     while(!previous.isEmpty()){
    //         for(TreeLinkNode tmp : previous){
    //             if(tmp == null){
    //                 break;
    //             }

    //             if(tmp.left != null){
    //                 current.push(tmp.left);
    //                 current.push(tmp.right);
    //                 tmp.left.next = tmp.right;
    //             }
                

    //             if(tmp.next != null){
    //                 if(tmp.right !=null){
    //                     tmp.right.next = tmp.next.left;
    //                 }
    //             }

    //         }

    //         previous = current;
    //         current = new LinkedList<TreeLinkNode>();
    //     }    

    // }
    // public void connect(TreeLinkNode root){
    //     if(root == null){
    //         return;
    //     }

    //     if(root.left != null){
    //         root.left.next = root.right;
    //     }

    //     if(root.right !=null){
    //         root.right.next = root.next!=null? root.next.left : null;
    //     }

    //     connect(root.left);
    //     connect(root.right);
    // }

    // public void connect(TreeLinkNode root){
    //     //Solution using constant space.
    //     if(root == null){
    //         return;
    //     }

    //     TreeLinkNode parent = root;
    //     TreeLinkNode nextLevel = root.left;
    //     TreeLinkNode leftNode = null;

    //     while(parent != null && nextLevel != null){
    //         leftNode = null;
    //         while(parent!=null){
    //             if(leftNode == null){
    //                 leftNode = parent.left;
    //             }else{
    //                 leftNode.next = parent.left;
    //                 leftNode = leftNode.next;
    //             }

    //             leftNode.next = parent.right;
    //             leftNode = leftNode.next;
    //             parent = parent.next;
    //         }

    //         parent = nextLevel;
    //         nextLevel = parent.left;
    //     }
    // }

    public void connect(TreeLinkNode root){
        if(root == null){
            return;
        }

        LinkedList<TreeLinkNode> previous = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> current = new LinkedList<TreeLinkNode>();
        TreeLinkNode tmp = null;
        previous.add(root);

        while(!previous.isEmpty()){

            while(!previous.isEmpty()){
                tmp = previous.poll();
                if(tmp.left !=null){
                    current.add(tmp.left);
                    current.add(tmp.right);
                }
                if(!previous.isEmpty()){
                    tmp.next = previous.peek();
                }
            }

            previous = current;
            current = new LinkedList<TreeLinkNode>();
        }
    }
}










