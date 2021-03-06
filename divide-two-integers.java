// Divide two integers without using multiplication, division and mod operator.


public class Solution {
    public int divide(int dividend, int divisor) {
        // assume given divisor will always be non-zero.
        if(dividend == 0){
            return 0;
        }

        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);


        // When divisor == Integer.MIN_VALUE, will cause infinite loop, why?
        // the binary representation of Integer.MIN_VALUE is : 100000000000...0
        // the abs value of it doesnt chage, which remains: 100000...000
        // so when you double the value of it by doing bitwise right shift, it
        // will become 000.000, which will cause the decimal value of it to 0,
        // so the first while loop will become infite, causing the TLE error.

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
            
        return isNeg?  neg(res) : res; 
    }

    private int neg(int x){
        return ~x + 1;
    }
}


public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = dividend > 0? divisor < 0 : divisor > 0;

        long dvd  = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        long doubledTimes = 0;
        // double the value of divisor as close to dividend as possible
        while (dvd >= (dvs << 1)) {
            dvs = dvs << 1;
            doubledTimes++;
        }

        long res = 0;
        while (doubledTimes >= 0) {
            if (dvd >= dvs) {
                dvd -= dvs;
                res += (1L << doubledTimes);
            }
            doubledTimes--;
            dvs = dvs >> 1;

        }

        if (res > Integer.MAX_VALUE) {
            return isNeg? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return isNeg? (int)(-res) : (int)res;

    }
}