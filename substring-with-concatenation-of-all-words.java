// You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

// For example, given:
// S: "barfoothefoobarman"
// L: ["foo", "bar"]

// You should return the indices: [0,9].
// (order does not matter).

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new ArrayList<Integer>();
        int wordsNum = L.length;
        if(wordsNum == 0) return list;

        int sLen = S.length();
        int wordLen = L[0].length();
        int window = wordLen * wordsNum;
        if(sLen < window) return list;
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String s : L){
        	map.put(s, map.containsKey(s)? map.get(s) + 1 : 1);
        } 

        for(int i = 0; i <= (sLen - window); i++){
        	String tempString = S.substring(i, i + window);
        	int matched = 0;
        	HashMap<String, Integer> mapCopy = new HashMap<String, Integer>(map);
        	for(int j = 0; j < tempString.length(); j += wordLen){
        		String substring = tempString.substring(j, j + wordLen);
        		if(mapCopy.containsKey(substring)){
        			if(mapCopy.get(substring) < 1){
        				break;
        			}
        			mapCopy.put(substring, mapCopy.get(substring) - 1);
        			matched++;
        		}
        	}

        	if(matched == wordsNum){
        		list.add(i);
        	}
        }

        return list;
    }
}