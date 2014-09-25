// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct(int[] A) {
        int len = A.length;
        if(len == 0){
            return 0;
        }

        int max = A[0];
        int min = A[0];
        int res = A[0];

        for (int i = 1; i < len; i++){
            int a = max * A[i];
            int b = min * A[i];
            int c = A[i];
            max = Math.max(a, Math.max(b, c));
            min = Math.min(a, Math.min(b, c));
            res = max > res? max : res;
        }
        return res;
    }
}