// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return the minimum cuts needed for a palindrome partitioning of s.

// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class Solution {
	public int minCut(String s) {
		int len = s.length();
		if(len == 0) return len;

		int[] cuts = new int[len + 1];
		boolean[][] m = new boolean[len][len];

		for(int i = 0; i <= len; i++){
			cuts[i] = len - i;
		}

		for(int i = len - 1; i >= 0; i--){
			for(int j = i; j < len; j++){
				boolean sameChar = s.charAt(i) == s.charAt(j);
				if( (sameChar&&(j - i < 2) )|| (sameChar && m[i + 1][j - 1])){
					m[i][j] = true;
					int rightCut = cuts[j + 1] + 1;
					int currentCut = cuts[i];
					cuts[i] = currentCut < rightCut? currentCut : rightCut;
				}
			}
		}

		return cuts[0] - 1;
	}
}



// write your own ppii solution.
// write own ppi solution that use 2d dp.


// minimum cut to split input string s into 
// substrings that are all palindrome.


// "aab" -> "aa", "b" --> 1
// "aaa" -> "aaa" -> 0
// "abcd" --> a,b,c,d -> 3


// use an array cut[], cut[i] represents the number of cuts needed
// to split string s[i..end] into all palindrome.

//##!!!## Question: Think carefully: why not use cut[i] to represent s[0..i], instead
// we use cut[i] to represent cuts needed to split s[i..end] into all palindromes.
// Answer: Based on the dp approach we are using, if at a point we have index i,j, we
// should have sub-problem substring(i+1, j-1) solved, which means we better start from
// i : end to 0, j: i to end.(draw a dp matrix here to get a better idea.)
//Still: why not cut[i]-->s[0..i]??
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        if(len <= 1){
            return 0;
        }

        int[] cut = new int[s.length() + 1];

        // for "aab", i = 1, cut[1] = 1 --> "aa"-->"a","a" needs one cut
        // this step represents the worst case, all palindromes
        // are single characters.
        for(int i = 0; i <= len; i++){
            cut[i] = len - i;
        }

        // 2D dp, dp[i][j] represents whether substring(i, j) is valid palindrome.
        boolean[][] dp = new boolean[len][len];
//        for(int i = len - 1; i >= 0; i--){
//            for(int j = i; j < len; j++){
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(i == j){
                    dp[i][j] = true;
                    // continue;
                }//0123456789
                //"cabababcbc";
                // if char at i and j are the same.
                boolean isSameChar = s.charAt(i) == s.charAt(j);
                if(isSameChar){
                    if(j - i <= 2){
                        dp[i][j] = true;
                    }else{
                        // shorter string is palindrome.
                        if(dp[i + 1][j - 1]){
                            dp[i][j] = true;
                        }
                    }
                }

                if(dp[i][j]){
                    cut[i] = Math.min(cut[i], cut[j + 1] + 1);
                }
            }
        }
        return cut[0] - 1;
    }
}
