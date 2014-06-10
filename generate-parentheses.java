// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();

        if(n == 0){
        	list.add("");
        	return list;
        }
        
        StringBuilder sb = new StringBuilder();
        helper(list, sb, n, n);

        return list;
    }

    public void helper(List<String> list, StringBuilder sb, int left, int right){
    	// if(left < 0) return;
    	if(left == 0 && right == 0){
    		// compete combination.
    		list.add(sb.toString());
    		sb = new StringBuilder();
    		return;
    	}

    	if(left > 0){
    		sb.append('(');
    		helper(list, sb, left - 1, right);
    		sb.deleteCharAt(sb.length() - 1);
    	}

    	if(right > 0 && right > left){
    		sb.append(')');
    		helper(list, sb, left, right - 1);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
}