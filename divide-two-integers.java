// Divide two integers without using multiplication, division and mod operator.


public class Solution {
    public int divide(int dividend, int divisor) {
        // assume given divisor will always be non-zero.
        if(dividend == 0){
            return 0;
        }

        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long dvd  = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        // dividend = Math.abs(dividend);
        // divisor = Math.abs(divisor);
        int step = 0;

        while((dvs << 1) <= dvd){
            dvs <<= 1;
            step++;
        }

        int res = 0;

        while(step >= 0){
            if(dvd >= dvs){
                dvd -= dvs;
                    res += 1 << step;   
            }

            dvs >>= 1;
            step--;
        }
            
        return res; 
    }
}