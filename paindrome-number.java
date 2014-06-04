// Determine whether an integer is a palindrome. Do this without extra space.

public class Solution {
    // public boolean isPalindrome(int x) {
    //     if(x < 0){
    //         return false;
    //     }
        
    // 	int len = (int)Math.log10(x);

    // 	while(len > 0){
    // 		int low = x % 10;
    // 		int high = x /((int) Math.pow(10, len));

    // 		if( low != high){
    // 			return false;
    // 		}

    // 		x = x - high * (int) Math.pow(10, len);
    // 		x /= 10;
    // 		len -= 2;
    // 	}

    // 	return true;
    // }

    public boolean isPalindrome(int x){
    	if( x < 0){
    		return false;
    	}

    	return x == reverse(x);
    }

    public int reverse(int x){
    	int res = 0;

    	while(x > 0){
    		res = res * 10 + x % 10;
    		x /= 10;
    	}

    	return	res;
    }
}