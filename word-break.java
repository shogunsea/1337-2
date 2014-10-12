// Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
    	if(s.length() < 1) return false;

        boolean[] splitPoint = new boolean[s.length() + 1];
        splitPoint[0] = true;

        for(int i = 0; i <= s.length(); i++){
        	for(int j = 0; j < i; j++){
        		String subString = s.substring(j, i);
        		if(splitPoint[j] && dict.contains(subString)){
        			splitPoint[i] = true;
        			break;
        		}
        	}
        } 

        return splitPoint[s.length()];
    }
}


 // public boolean wordBreak(String s, Set<String> dict) {
 //        // recursive approach: in each recursion, iterate over
 //        // all dict words, if starting from current index, the substring
 //        // is same as dict word, go down to next level recursion, if it 
 //        // returns true then current recursion also returns true.
 //        return dfsHelper(s, dict, 0);
 //    }
    
 //    public boolean dfsHelper(String s, Set<String> dict, int start) {
 //        if (start == s.length()) {
 //            return true;
 //        }
        
 //        for (String word : dict) {
 //            int wordLen = word.length();
 //            int index = wordLen + start;
 //            if (index > s.length()) {
 //                continue;
 //            }
            
 //            if (s.substring(start, index).equals(word)) {
 //                if (dfsHelper(s, dict, index)) {
 //                    return true;
 //                }
 //            }
 //        }
        
 //        return false;
 //    }