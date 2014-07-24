// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> tempList = new ArrayList<String>();

        if(s.length() < 1){
        	result.add(tempList);
        	return result;
        }

        dfs(result, tempList, s, 0);

        return result;
    }

    public void dfs(List<List<String>> result, List<String> tempList, String s, int index){
    	if(index == s.length()){
    		List<String> match = new ArrayList<String>(tempList);
    		result.add(match);
    		return;
    	}
    	for(int i = index; i <= s.length(); i++){
    		String tempString = s.substring(index, i);
    		if(isPalindrome(tempString)){
    			tempList.add(tempString);
    			dfs(result, tempList, s, i);
    			tempList.remove(tempList.size() - 1);
    		}
    	}
    }

    public boolean isPalindrome(String s){
    	if(s.length() == 0) return false;
    	
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) == s.charAt(j)){
                continue;
            }
            return false;
        }
        
        return true;
    }
}