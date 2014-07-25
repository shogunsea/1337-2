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