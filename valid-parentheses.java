// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
    	int len = s.length();

    	if(len == 0) return true;

    	Stack<Character> st = new Stack<Character>();

    	char[] chars = s.toCharArray();

    	for(char c : chars){
    		if(c == ')' || c == '}' || c == ']'){
    			if(st.isEmpty()){
    				return false;
    			}else{
    				if(st.pop() == pair(c)){
    					continue;
    				}else{
    					return false;
    				}
    			} 
    		}else{
    			st.push(c);
    		}
    	}

    	if(st.isEmpty()){
    		return true;
    	}

    	return false;
    }

    public char pair(char c){
    	char pair = '';
    	switch(c){
    		case ')':
				pair = '(';
				break;
			case ']':
				pair = '[';
				break;
			case '}':
				pair = '{';
				break;
    	}

    	return pair;
    }
}