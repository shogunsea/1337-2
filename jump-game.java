// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

// Greedy : O(n)
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

// dp : O(n^2) at worst case.
public class Solution {
    public boolean canJump(int[] A) {
        int len = A.length;

        if (len <= 1) {
            return true;
        }       

        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (A[i] + i >= j && dp[i]) {
                    dp[j] = true;
                    break;
                }
            }
        }

        return dp[len - 1];
    }
}