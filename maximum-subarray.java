public class Solution {
    // public int maxSubArray(int[] A) {
    //     if (A == null || A.length == 0){
    //         return 0;
    //     }
        
    //     int max = Integer.MIN_VALUE, sum = 0;
    //     for (int i = 0; i < A.length; i++) {
    //         sum += A[i];
    //         max = Math.max(max, sum);
    //         sum = Math.max(sum, 0);
    //     }

    //     return max;
    // }

    public int maxSubArray(int[] A){
        int sum = A[0];
        int max = A[0];

        for(int i = 1; i < A.length; i++){
            // as long as previous sum is positive, it can
            // contribute to following subarray. however
            // negative values in the folloing subarry 
            // might decrease the totalsum, so we need to 
            // update the global sum with possible
            // maximal sum.
            sum = sum < 0? A[i] : sum + A[i];
            max = sum > max ? sum : max;
        }

        return max;
    }
}
