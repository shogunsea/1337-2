// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].

public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;

        if(len == 0) return len;

        int slow = 0;
        // fast starts from 0 or 1 both pass
        int fast = 1;

        while(fast < len){
            if(A[fast] == A[slow]){
                fast++;
            }else{
                // fast++ or fast, both pass all test cases.
                A[++slow] = A[fast++];
            }
        }

        return ++slow;
    }
}