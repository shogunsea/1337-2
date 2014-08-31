// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
        matched[0][0] = true;

        for(int i = 1; i <= s1.length(); i++){
        	if(s1.charAt(i - 1) == s3.charAt(i - 1)){
        		matched[i][0] = true;
        	}else break;
        }

        for(int i = 1; i <= s2.length(); i++){
        	if(s2.charAt(i - 1) == s3.charAt(i - 1)){
        		matched[0][i] = true;
        	}else break;
        }

        for(int i1 = 1; i1 <= s1.length(); i1++){
        	char c1 = s1.charAt(i1 - 1);
        	for(int i2 = 1; i2 <= s2.length(); i2++){
        		char c2 = s2.charAt(i2 - 1);
        		int i3 = i1 + i2;
        		boolean fromS1 = (s1.charAt(i1 - 1) == s3.charAt(i3 - 1)) && matched[i1 - 1][i2];
        		boolean fromS2 = (s2.charAt(i2 - 1) == s3.charAt(i3 - 1)) && matched[i1][i2 - 1];
        		matched[i1][i2] = fromS1 || fromS2;
        	}
        }

        return matched[s1.length()][s2.length()];
    }
}
