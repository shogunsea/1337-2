// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.

public class Solution {
    public boolean isPalindrome(String s) {
    	s = s.trim();
    	int len = s.length();

    	if(len == 0) return true;

    	int start = 0; 
    	int end = len - 1;

    	while(start < end){
    		while(start < len - 1 && !validChar(s.charAt(start))){
    			start++;
    		}

    		while(end >= 0 && !validChar(s.charAt(end)) ){
    			end--;
    		}

    		if(start >= end){
    			return true;
    		}

    		if(start < len - 1 && end >= 0 && match(s.charAt(start), s.charAt(end))){
    			start++;
    			end--;
    		}else{
    			return false;
    		}
    	}

    	return true;
    }

    public boolean validChar(char c){
    	boolean upper = c <= 'Z' && c >= 'A';
    	boolean lower = c <= 'z' && c >= 'a';
    	boolean num = c >= '0' && c <= '9';
    	return upper || lower || num;
    }

    public boolean match(char a, char b){
    	return (a - b == 32 || a - b == -32 || a == b)? true : false;
    }
}