// Implement int sqrt(int x).

// Compute and return the square root of x.

public class Solution {
    public int sqrt(int x) {
    	if (x <= 1) {
            return x;
        }

        int start = 0;
        int end = x / 2;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            long tempRes = (long)mid * mid;
            if (tempRes >= x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        long startRes = (long)start * start;
        long endRes = (long)end * end;

        if (endRes > x) {
            return start;
        } else {
            return end;
        }
	}
}