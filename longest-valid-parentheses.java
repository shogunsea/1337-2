// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public class Solution {
    public int longestValidParentheses(String s) {
    	int len = s.length();

    	if(len == 0) return 0;

    	Stack<Integer> st = new Stack<Integer>();

    	char[] chars = s.toCharArray();
    	int accumulation = 0;
    	int max = 0;

    	for(int i = 0; i < len; i++){
    		if(chars[i] == '('){
    			st.push(i);
    		}else{
    			if(st.isEmpty()){
    				accumulation = 0;
    			}else{
    				int matchedPos = st.pop();
    				int matchedLen = i - matchedPos + 1;

    				if(st.isEmpty()){
    					accumulation += matchedLen;
    					matchedLen = accumulation;
    				}else{
    					matchedLen = i - st.peek();
    				}

    				max = max < matchedLen? matchedLen : max;
    			}
    		}
    	}

    	return max;
	}
}