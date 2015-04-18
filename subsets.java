// Given a set of distinct integers, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();

        if( S.length == 0) return result;

        Arrays.sort(S);

        for(int i = 0; i <= S.length; i++){
        	dfs(S, result, tempList, i, 0);
        }

        return result;
    }

    public void dfs(int[] S, List<List<Integer>> result, List<Integer> tempList, int len, int index){
    	if(tempList.size() == len){
    		result.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for(int i = index; i < S.length; i++){
    		// go through all possible elements.
    		tempList.add(S[i]);
    		dfs(S, result, tempList, len, i + 1);
    		tempList.remove(tempList.size() - 1);
    	}
    }
}


// Bit + Math solution.
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = S.length;
        if (len == 0) {
            return res;
        }
        
        int pow = (int)Math.pow(2, len);
        
        Arrays.sort(S);
        
        for (int i = 0; i < pow; i++) {
            List<Integer> tempList = new ArrayList<Integer>();
            for (int j = 0; j < len; j++) {
                int p = 1 << j;
                if ((p & i) != 0) {
                    tempList.add(S[j]);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}