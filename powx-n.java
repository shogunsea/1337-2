// Implement pow(x, n).

public class Solution {
	// brute-force approach got TLE, need divide and conquer approach.
	// brute-force: O(n)
	// divide-conqueer: T(n) = T(n/2) + O(1) ---> O(logn)
    public double pow(double x, int n) {
        if(n == 1){
            return x;
        }else if(n == 0){
            return 1;
        }

        double res = pow(x, n / 2);
        
        if(n % 2 == 0){
            // even
            return res * res;
        }else{
            // odd
            if(n < 0) x = 1 / x; 
            return res * res * x;
        }
    }
}