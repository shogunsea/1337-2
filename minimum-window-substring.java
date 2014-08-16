// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the emtpy string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class Solution {
    public String minWindow(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        if(sLen == 0 || tLen == 0) return "";

        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();

        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();

        for(char t : tChars){
        	dict.put(t, dict.containsKey(t)? dict.get(t) + 1 : 1);
        	found.put(t, 0);
        }

        int minEnd = sLen;
        int minStart = -1;
        int start = 0;
        int end = 0;
        int count = 0;

        for(; end < sLen; end++){
        	char c = sChars[end];
        	if(dict.containsKey(c)){
        		found.put(c, found.get(c) + 1);

        		if(found.get(c) <= dict.get(c)){
        			count++;
        		}

        		if(count == tLen){
        			while(!dict.containsKey(sChars[start]) || found.get(sChars[start]) > dict.get(sChars[start])){
        				if(dict.containsKey(sChars[start])){
        					found.put(sChars[start], found.get(sChars[start]) - 1);
        				}
        				start++;
        			}

        			if(end - start < minEnd - minStart){
        				minEnd = end;
        				minStart = start;
        			}
        		}
        	}
        }

        return minStart == -1? "" : S.substring(minStart, minEnd + 1);
    }
}