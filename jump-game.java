// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

public class Solution {
    public boolean canJump(int[] A) {
 		int len = A.length;

        if(len <= 1) return true;

        int maxReachedIndex = 0;

        for(int i = 0; i < len; i++){
        	// means if max reached indexed calculated so far is smaller than i, then something is wrong.
            if(maxReachedIndex < i) return false;
            maxReachedIndex = maxReachedIndex > i + A[i]? maxReachedIndex : i + A[i];
        }

        return true;
    }
}