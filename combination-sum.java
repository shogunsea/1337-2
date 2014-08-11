// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = candidates.length;
		List<Integer> tempList = new ArrayList<Integer>();

		if(len == 0) return	 result;

		Arrays.sort(candidates);

		dfs(result, tempList, candidates, target, 0, 0, len);

		return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int currentSum, int index, int len){
    	if(currentSum == target){
    		result.add(new ArrayList<Integer>(tempList));
    		return;
    	}else if(index == len){
    		return;
    	}

    	for(int i = index; i < candidates.length; i++){
    		if(currentSum + candidates[i] <= target){
    			tempList.add(candidates[i]);
	    		dfs(result, tempList, candidates, target, currentSum + candidates[i], i, len);
	    		tempList.remove(tempList.size() -1);
    		}
    	}
    }
}












