// Implement wildcard pattern matching with support for '?' and '*'.

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

public class Solution {
    public boolean isMatch(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();
        if(len_s == 0){
            return p.equals("*") || p == s;
        }

        int count = 0;
        for(int i = 0;i< len_p;i++){
            if(p.charAt(i) != '*') count++;
        }
        if(count > len_s) return false;

        boolean[][] mark = new boolean[len_s+1][len_p+1];
        mark[0][0] = true;
        // match the leading empty string!!
        for (int i = 0; i < len_p; i++) {
            if(p.charAt(i) == '*'){
                mark[0][i+1] = true;
            }else{
                break;
            }
        }
        for (int i = 1; i <= len_s; i++) {
            char ch_s = s.charAt(i-1);
            for(int j = 1;j<= len_p;j++){
                char ch_p = p.charAt(j-1);
                if(ch_p == ch_s  || ch_p == '?'){
                    mark[i][j] = mark[i-1][j-1];
                }else if(ch_p == '*'){
                    mark[i][j] = mark[i][j-1] || mark[i-1][j-1] || mark[i-1][j];
                }else{
                    mark[i][j] = false;
                }
            }
        }
        return mark[len_s][len_p];
    }
}