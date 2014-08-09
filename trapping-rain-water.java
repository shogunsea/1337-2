// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


public class Solution {
	// brute force search. O(n2) 
  //   public int trap(int[] A) {
		// int len = A.length;

		// if(len == 0) return 0;

		// int water = 0;


		// // [4,2,3]
		// for(int i = 1; i < len - 1; i++){
		// 	int current = A[i];
		// 	int left = -1;
		// 	int right = -1;

		// 	for(int l = i - 1; l >= 0; l--){
		// 		if(A[l] > current){
		// 			left = left > A[l]? left : A[l];
		// 		}
		// 	}

		// 	if(left == -1) continue;

		// 	for(int r = i + 1; r < len; r++){
		// 		if(A[r] > current){
		// 			right = right > A[r]? right : A[r];
		// 		}
		// 	}

		// 	if(right == -1) continue;

		// 	water += (Math.min(left, right) - current);
		// }

		// return water;
  //   }

	// dp approach, O(n)
	public int trap(int[] A) {
		int len = A.length;

		if( len == 0 ) return len;

		int[] leftMax = new int[len];

		int tempMax = A[0];
		leftMax[0] = tempMax;

		for(int i = 1; i < len - 1; i++){
			tempMax = Math.max(tempMax, A[i - 1]);
			leftMax[i] = tempMax;
		}

		int water = 0;
		int right = A[len - 1];

		for(int i = len - 2; i >= 0; i--){
			int left = leftMax[i];
			right = Math.max(right, A[i + 1]);

			int lower = left > right? right : left;

			if(lower > A[i]){
				water += (lower - A[i]);
			}
		}

		return water;
	}
}