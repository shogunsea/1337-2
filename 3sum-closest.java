// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {
	// intuitively, brute force approach may solve this problem. O(n3)
    // public int threeSumClosest(int[] num, int target) {
    // 	int error = Integer.MAX_VALUE;
    // 	int sum = 0;
    // 	for(int i = 0; i < num.length; i++){
    // 		for(int j = i + 1; j < num.length; j++){
    // 			for(int k = j + 1; k < num.length; k++){
    // 				int tempSum = num[i] + num[j] + num[k];
    // 				if(tempSum == target) return target;
    // 				int tempError = Math.abs(target - tempSum);
    // 				if(tempError < error){
    // 					error = tempError;
    // 					sum = tempSum;
    // 				}
    // 			}
    // 		}
    // 	}

    // 	return sum;
    // }

	// use two pointers technique, reduce O(n3) to O(n2)
    public int threeSumClosest(int[] num, int target) {
    	int error = Integer.MAX_VALUE;
    	int sum = 0;

    	Arrays.sort(num);

    	for(int i = 0; i < num.length; i++){
    		int j = i + 1;
    		int k = num.length - 1;

    		while(j < k){
    			int tempSum = num[i] + num[j] + num[k];
    			if(tempSum == target) return target;
    			if(Math.abs(target - tempSum) < error){
    				error = Math.abs(target - tempSum);
    				sum = tempSum;
    			}

    			if(tempSum < target){
    				j++;
    			}else{
    				k--;
    			}
    		}
    	}

    	return sum;
    }
}