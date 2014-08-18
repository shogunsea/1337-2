// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.

public class Solution {
	// Find the first missing positive integer, meaning we 
	// should start checking from 1, and for an input 
	// array of size N, the missing integer should not be
	// larger than N+1.
	// For example: A = {1,2,3} N = 3, we have N+1 = 4 missing
	// with elements in A being all increasing integers starting
	// with 1. If A = {1,2, 130}. 3 is missing. So we just need
	// to map all values in A to a similar size array.
    public int firstMissingPositive(int[] A) {
    	int len = A.length;
    	if(len == 0) return 1;

    	int[] dp = new int[len + 1];

    	for(int i = 0; i < len; i++){
    		if(A[i] > 0 && A[i] <= len){
    			dp[A[i]] = 1;
    		}
    	}

    	int miss = 1;

    	for(int i = 1; i <= len; i++){
    		if(dp[i] == 0){
    			miss = i;
    			break;
    		}

    		if(dp[i] == 1 && i == len){
    			miss = i + 1;
    			break;
    		}
    	}

    	return miss;
    }
}