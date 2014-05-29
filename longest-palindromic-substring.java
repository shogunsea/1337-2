// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


public class Solution {
    public String longestPalindrome(String s) {
    	if(s.length() == 0){
    		return s;
    	}

    	int len = s.length();

    	int max = 0;
    	int oddLen, evenLen, curLen, pos;
    	for(int i = 0; i < len; i++){
    		oddLen = palinLen(s, i, i);

    		if(i + 1 < len){
    			evenLen = palinLen(s, i, i + 1);
    		}

    		curLen = oddLen > evenLen? oddLen : evenLen;

    		if(curLen > max){
    			max = curLen;

    			if(max % 2 == 0){
    				pos = i - (max - 1) / 2;
    			}else{
    				pos = i - max / 2;
    			}
    		}
    	}

    	return s.substring(pos, pos + max);
    }

    public int palinLen(String s, int i, int j){
    	int len = 0;

    	while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
    		i--;
    		j++;
    	}

    	i++;
    	j--;
    	len = j - i + 1;
    	return len;
    }
}