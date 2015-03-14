// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
	    		dfs(result, tempList, candidates, target, currentSum + candidates[i], i + 1, len);
	    		tempList.remove(tempList.size() -1);
                while(i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
    		}
    	}
    }
}












