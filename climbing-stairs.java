public class Solution {
    public int climbStairs(int n) {
        if (n % 2 == 0) {
            int[] temp = new int[n + 1];
            return recur(n, temp);
        } else {
            return iter(n);
        }
    }
    public int recur(int n, int[] buf) {
        if (n <= 2) {
            return n;
        }
        if (buf[n] != 0) {
            return buf[n];
        }
        
        buf[n] = recur(n - 1, buf) + recur(n -2, buf);

        return buf[n];        
    }
    
    public int iter(int n) {
        if (n <= 2) {
            return n;
        }
        
        // third = first + second
        // ways to get to first stair
        int one = 1;
        // ways to get to second starit
        int two = 2;
        
        while (n-- != 2) {
            int three = one + two;
            one = two;
            two = three;
        }
        
        return two;
    }
}