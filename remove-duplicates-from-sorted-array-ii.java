// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array A = [1,1,1,2,2,3],

// Your function should return length = 5, and A is now [1,1,2,2,3].

public class Solution {
    public int removeDuplicates(int[] A) {
		int len = A.length;

		if(len < 3) return len;

		int fast = 1;
		int slow = 0;
		int counter = 1;

		while(fast < len){
			if(A[fast] == A[slow]){
				if(counter >= 2){
					fast++;
				}else{
					counter++;
					A[++slow] = A[fast++];
				}
			}else{
				counter = 1;
				A[++slow] = A[fast++];
			}
		}

		return ++slow;
    }
}