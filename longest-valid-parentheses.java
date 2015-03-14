// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public class Solution {
    // key point: when do we update accumulation length?
    public int longestValidParentheses(String s) {
    	int len = s.length();
        if(len == 0){
            return 0;
        }
        
    	Stack<Integer> st = new Stack<Integer>();
    	char[] chars = s.toCharArray();
    	int accumulation = 0;
    	int max = 0;

    	for(int i = 0; i < len; i++){
    		if(chars[i] == '('){
    			st.push(i);
    		}else{
    			if(st.isEmpty()){
                    // no left paren for right paren, accumulation set to zero.
    				accumulation = 0;
    			}else{
    				int matchedPos = st.pop();
    				int matchedLen = i - matchedPos + 1;

    				if(st.isEmpty()){
                        // just happen to be emptpy: continuous match.
                        // continuous matching is not enough: it also means that no potential pairs with left
                        // paren stored to be matched. so we can update the accumulation.
    					accumulation += matchedLen;
                        max = Math.max(max, accumulation);
    				}else{
    					matchedLen = i - st.peek();
                        max = Math.max(max, matchedLen);
    				}
    			}
    		}
    	}

    	return max;
	}
}