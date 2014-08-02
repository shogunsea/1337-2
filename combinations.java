// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] S = new int[n];

        for(int i = 0; i < n; i++){
        	S[i] = i + 1;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();

    	dfs(S, result, tempList, k, 0);

        return result;
    }

    public void dfs(int[] S, List<List<Integer>> result, List<Integer> tempList, int len, int index){
    	if(tempList.size() == len){
    		result.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for(int i = index; i < S.length; i++){
    		tempList.add(S[i]);
    		dfs(S, result, tempList, len, i + 1);
    		tempList.remove(tempList.size() - 1);
    	}
    }
}