// Implement int sqrt(int x).

// Compute and return the square root of x.

public class Solution {
    public int sqrt(int x) {
    	int high = x / 2 + 1;
    	int low = 0;

    	while(high >= low){
    		int mid = (high + low) / 2;
    		int sq = mid * mid;
    		if(sq == x){
    			return mid;
    		}else if(sq < x){
    			low = mid + 1;
    		}else{
    			high = mid - 1;
    		}
    	}

    	return high;
	}
}