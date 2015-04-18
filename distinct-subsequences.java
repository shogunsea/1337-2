// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.

public class Solution {
	// Very likely to be solved using DP. so finally worked this
	// out by myself. Just need to draw the matrix on paper
	// and run the example test and u will get the logic pretty
	// easy. Though I made sereral wrong observation and incorrect
	// logic, but eventually got it right.
	// Time and space are both O(MN).
    public int numDistinct(String S, String T) {
    	int col = S.length();
    	int row = T.length();
    	if(col == 0 || row == 0) return 0;

    	int[][] dp = new int[row][col];

    	// Initialize first row.
    	for(int i = 0; i < col; i++){
    		if(i == 0){
    			if(S.charAt(i) == T.charAt(0)){
    				dp[0][i] = 1;
    			}
    		}else{
    			if(S.charAt(i) == T.charAt(0)){
    				dp[0][i] = dp[0][i - 1] + 1;
    			}else{
    				dp[0][i] = dp[0][i - 1];
    			}
    		}
    	}

    	for(int i = 1; i < row; i++){
    		for(int j = 1; j < col; j++){
    			if(j < i){
    				dp[i][j] = 0;
    				continue;
    			} 
    			boolean sameChar = S.charAt(j) == T.charAt(i);
    			if(sameChar){
    				if(i == j){
    					dp[i][j] = dp[i - 1][j - 1];
    				// }else if(dp[i -1][j] != 0 && dp[i][j - 1] != 0){
    				// 	dp[i][j] = dp[i - 1][j - 1] + 1;
    				// }else if(dp[i][j - 1] != 0){
    				// 	dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
    				// }else{
    				// 	dp[i][j] = dp[i - 1][j];
    				// }
    				}else{
    					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
    				}
    			}else if(dp[i][j - 1] != 0){
    				dp[i][j] = dp[i][j - 1];
    			}
    		}
    	}

    	return dp[row - 1][col - 1];
    }

    public static int distinctSub(String row, String col) {
        // longer string as row
//        if (row.length() < col.length()) {
//            return distinctSub(col, row);
//        }

        int rowLen = row.length();
        int colLen = col.length();
        if (rowLen == 0 || colLen == 0) {
            return 0;
        }
        int[][] dp =  new int[rowLen][colLen];
        // dp[i][j]: pick i chars from row, j chars from col. Number of different
        //      subsequences of col[:j] in row[:i]
        // initialize first col, only lower half of the matrix will be filled.
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (j > i) {
                    // index of shorter string is bigger: invalid
                    continue;
                }

                char rowChar = row.charAt(i);
                char colChar = col.charAt(j);

                if (rowChar == colChar) {
                    if (j == 0 && i != 0) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else if (i != 0){
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        // i == 0 && j == 0
                        dp[i][j] = 1;
                    }
                } else {
                    if (i != 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[rowLen - 1][colLen - 1];
    }
}