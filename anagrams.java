// Given an array of strings, return all groups of strings that are anagrams.

// Note: All inputs will be in lower-case.

public class Solution {

	// my own, straight forward, but slow solution...
	// tried to reduce unnecessary calculation by applying 2D dp,
	// but it turns out that this problem is not good for using DP,
	// cuz sub-problems are more independent than related, anagrams group
	// only contains two strings at most(even in the test case that contains 
	// 1000 input string )...    my algorithm would work better
	// if the number of anagrams in same group is larger(the larger the faster)..nvm..learned a 
	// lesson. Note that I tried on my machine that this solution outputs same
	// answers comparing with correct one, just slower.
    // public List<String> anagrams(String[] strs) {
    //     List<String> list= new ArrayList<String>();
    //     int len = strs.length;

    //     if(len == 0) return list;

    //     boolean[][] dp = new boolean[len][len];

    //     String first = strs[0];
    //     // fill the first row/col of the matrix.
    //     for(int col = 0; col < len; col++){
    //     	dp[col][col] = true; 
    //     	if(col == 0) continue;

    //     	if(isAnagram(first, strs[col])){
    //     		dp[0][col] = true;
    //     		// dp[col][0] = true;
    //     	} 
    //     }

    //     // fill the rest of the matrix based on previous calculation.
    //     for(int row = 1; row < len; row++){
    //     	for(int col = row + 1; col < len; col++){
    //     		if(row == col) continue;

    //     		// search for k in 0 <= k < row such that (k, col) or (k, row) is true.
    //     		boolean solved = false;
    //     		for(int k = 0; k < row; k++){
    //     			if(dp[k][col] && dp[k][row]){
    //     				solved = true;
    //     				dp[row][col] = true;
    //     			}
    //     		}

    //     		if(!solved){
    //     			dp[row][col] = isAnagram(strs[row], strs[col]);
    //     		}
    //     	}
    //     }

    //     Set<Integer> visitedIndexes = new HashSet<Integer>();
    //     for(int i = 0; i < len; i++){
    //     	boolean matched = false;
    //     	for(int j = i + 1; j < len; j++){
    //     		if(dp[i][j] && !visitedIndexes.contains(j)){
    //     			matched = true;
    //     			visitedIndexes.add(j);
    //     			list.add(strs[j]);
    //     		}
    //     	}
    //     	if(matched){
    //     		list.add(strs[i]);
    //     		visitedIndexes.add(i);
    //     	}
    //     }

    //     return list;
    // }

    // public boolean isAnagram(String a, String b){
    // 	int aLen = a.length();
    // 	int bLen = b.length();

    // 	if(aLen != bLen) return false;

    // 	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // 	for(int i = 0; i < aLen; i++){
    // 		int aChar = (int)a.charAt(i);
    // 		map.put(aChar, map.containsKey(aChar)? map.get(aChar) + 1 : 1);
    // 	}

    // 	for(int i = 0; i < bLen; i++){
    // 		int bChar = b.charAt(i);
    // 		if(!map.containsKey(bChar) || map.get(bChar) == 0){
    // 			return false;
    // 		}else{
    // 			map.put(bChar, map.get(bChar) - 1);
    // 		}
    // 	}

    // 	return true;
    // }


    public List<String> anagrams(String[] strs) {
		List<String> list = new ArrayList<String>();
		int len = strs.length;

		if(len == 0) return list;

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for(String s : strs){
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String tempString = new String(chars);

			if(!map.containsKey(tempString)){
				map.put(tempString, new ArrayList<String>());
			}

			map.get(tempString).add(s);
		}

		for(List<String> s : map.values()){
			if(s.size() > 1){
				list.addAll(s);
			}
		}

		return list;
	}
}