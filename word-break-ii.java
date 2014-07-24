// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].


public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

		if(s.length()==0||dict.size()==0){
     		return result;
     	}

     	int len = s.length();
     	boolean[] splitPoint = new boolean[len+1];
     	splitPoint[0] = true;

     	for(int i = 1; i<=len; i++){
     		for(int j = 0; j<i; j++){
     			String tempString = s.substring(j,i);
     			if(splitPoint[j]&&dict.contains(tempString)){
     				splitPoint[i]  = true;
     				break;
     			}

     		}
     	}

     	if(splitPoint[len]==false){
     		return result;
     	}

        dfs(result, sb, s, dict, 0);

        return result;
    }

    public void dfs(List<String> result, StringBuilder sb, String s, Set<String> dict, int index){
    	if(index == s.length()){
    		String match = sb.toString();
    		result.add(match);
    		return;
    	}

    	for(int i = index + 1; i <= s.length(); i++){
    		String tempString = s.substring(index, i);
    		if(dict.contains(tempString)){
    			int currentLength = sb.length();

    			if(currentLength == 0){
    				sb.append(tempString);
    			}else{
    				sb.append(" " + tempString);
    			}
    			dfs(result, sb, s, dict, i);
    			sb.delete(currentLength, sb.length());
    		}
    	}
    }
}