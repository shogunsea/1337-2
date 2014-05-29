public class Solution {
    public boolean isMatch(String s, String p) {
    	if(p.equals(".*") || s.length() == 0){
    		return true;
    	}else if(p.length() == 0){
    	    return false;
    	}

    	int sLen = s.length();
    	int pLen = p.length();
    	boolean[][] dp = new boolean[sLen][pLen];

    	if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
    		dp[0][0] = true;
    	}
    	

    	for(int i = 0; i < sLen; i++){
    		for(int j = 0; j < pLen; j++){
    			if( j == 0){
    				continue;
    			}

    			boolean conditionOne = (p.charAt(j - 1) == s.charAt(i) && p.charAt(j) == '*') || (p.charAt(j - 1) == '*' && p.charAt(j) == s.charAt(i));

    			if(i == 0){
    				if(conditionOne){
    					dp[i][j] = true;
    				}
    				continue;
    			}

    			boolean	charMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    			boolean conditionTwo = dp[i - 1][j - 1] && charMatch;
    			dp[i][j] = conditionTwo || conditionOne;
    		}
    	}

    	return dp[sLen - 1][pLen - 1];
	}
}