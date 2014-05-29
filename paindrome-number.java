// Determine whether an integer is a palindrome. Do this without extra space.

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
    	int len = (int)Math.log10(x);
    	int i = 0, j = len;

    	while(i < j){
    		int low = x % 10;
    		int high = x /((int) Math.pow(10, j));

    		if( low != high){
    			return false;
    		}

    		x = x - high * (int) Math.pow(10, j);
    		x /= 10;
    		j -= 2;
    // 		i++;
    	}

    	return true;
    }
}