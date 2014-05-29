// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


public class Solution {
    // public int climbStairs(int n) {
    // 	int[] dp = new int[n + 1];
    // 	dp[0] = 1;
    // 	dp[1] = 1;

    // 	for(int i = 2; i <= n; i++){
    // 		dp[i] = dp[i - 2] + dp[i - 1];
    // 	}

    // 	return dp[n];
    // }

    public int climbStairs(int n){
    	if(n <= 1){
    		return 1;
    	}

    	int[] dp = new int[n + 1];
    	dp[0] = 1;
    	dp[1] = 1;

    	return helper(dp, n);
    }

    public int helper(int[] dp, int n){
    	if(n <= 1){
    		return 1;
    	}

    	if(dp[n] != 0){
    		return dp[n];
    	}

    	dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
    	return dp[n];
    }
}