// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

public class Solution {
    public int search(int[] A, int target) {
    	int len = A.length;

    	if(len == 0) return -1;

    	int start = 0;
    	int end = len - 1;

    	while(start <= end){
    		int mid = (start + end) / 2;

    		if(A[mid] == target){
    			return mid;
    		}else if(A[mid] < A[end]){
    			// right half is sorted.
    			if(A[mid] < target && A[end] >= target){
    				start = mid + 1;
    			}else{
    				end = mid - 1;
    			}
    		}else {
    		//if(A[mid] > A[start]){
    			// left half is sorted.
    			if(A[mid] > target && A[start] <= target){
    				end = mid - 1;
    			}else{
    				start = mid + 1;
    			}
    		}
    	}

    	return -1;
    }
}
