// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 2;
        }
        
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// more readable logic.
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int res = 0;
        n -= 2;
        
        while (n > 0) {
            res = second + first;
            first = second;
            second = res;
            n--;
        }
        
        return res;
    }
}