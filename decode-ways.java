// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

public class Solution {
	// use recursive dfs and DP to solve this problem respectively.
	// Firstly gives out the dfs approach :: TLE
    // public int numDecodings(String s) {
    // 	int sLen = s.length();

    //     if(sLen == 0){
    //     	return sLen;
    //     }

    //     int[] counter = {0};

    //     dfs(s, sLen, 0, counter);

    //     return counter[0];
    // }

    // public void dfs(String s, int sLen, int index, int[] counter){
    // 	if(index == sLen){
    // 		counter[0] += 1;
    // 		return;
    // 	}

    // 	for(int i = index; i < sLen; i++){
    // 		String tempString = s.substring(index, i);
    // 		if(isValid(tempString)){
    // 			dfs(s, sLen, i, counter);
    // 		}
    // 	}
    // }

    public boolean isValid(String s, int start, int end){
    	if(end - start == 0 || end > s.length()) return false;

    	String subS = s.substring(start, end);
    	int num = Integer.parseInt(subS);
    	int subLen = subS.length();

    	if(subLen == 1){
    		return num > 0 && num <= 9;
    	}else{
    		return num > 9 && num <= 26;
    	}
    }

    public int numDecodings(String s) {
    	int sLen = s.length();
    	
    	if(sLen == 0 || s.charAt(0) == '0') return 0;

    	int[] dp = new int[sLen + 1];
    	dp[0] = isValid(s, 0, 1)? 1 : 0;
    	dp[1] = isValid(s, 1, 2)? dp[0] : 0;
    	dp[1] = isValid(s, 0, 2)? dp[1] + dp[0] : dp[1];

    	for(int i = 2; i < sLen; i++){
    		if(isValid(s, i, i + 1)){
    			dp[i] = dp[i - 1];
    		}
    		if(isValid(s, i - 1, i + 1)){
    			dp[i] += dp[i - 2];
    		}
    	}

    	return dp[sLen - 1];
    }
}