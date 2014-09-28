// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


public class Solution {
    public String longestPalindrome(String s) {
    	if(s.length() == 0){
    		return s;
    	}

    	int len = s.length();

    	int max = 0;
    	int oddLen = 0, evenLen = 0, curLen = 0, pos = 0;
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


public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        } else if (len == 1) {
            return s;
        }
        
        String res = "";
        int maxLen = 0;
        
        // iterate through s, each char as center, find longest palindrome.
        for (int i = 0; i < len; i++) {
            String tempString = palinHelper(s, i, i);
            if (tempString.length() > maxLen) {
                maxLen = tempString.length();
                res = tempString;
            }
            
            tempString = palinHelper(s, i, i + 1);
            if (tempString.length() > maxLen) {
                maxLen = tempString.length();
                res = tempString;
            }
        }
        
        return res;
    }
    
    public String palinHelper(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        return s.substring(start + 1, end);
    }
}        
        