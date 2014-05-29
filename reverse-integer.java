// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

// click to show spoilers.

public class Solution {
    public int reverse(int x) {
        int res = 0;
        int carry, remain;
        boolean positive = x > 0? true : false;
        x = Math.abs(x);

        while(x > 0){
        	carry = x % 10;
        	x = x / 10;
        	res = res * 10 + carry;
        }

        return positive? res : -res;
    }
}