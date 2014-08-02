// Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) return "";

    	String first= strs[0];
    	int end = first.length() == 0? 0 : first.length();

    	for(int i = 1; i < strs.length; i++){
    		String testString = strs[i];
    		int j = 0;

    		while(j < first.length() && j < testString.length() && testString.charAt(j) == first.charAt(j)){
    			j++;
    		}

    		end = end < j? end : j;
    	}

    	return first.substring(0, end);
    }
}