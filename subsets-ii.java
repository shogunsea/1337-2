// Given a collection of integers that might contain duplicates, S, return all possible subsets.

// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<Integer>();
		int len = num.length;

		if(len == 0) return result;

		Arrays.sort(num);

		for(int i = 0; i <= len; i++){
			dfs(result, tempList, num, i, 0);
		}       

		return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tempList, int[] num, int len, int index){
    	if(index == len){
    		result.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for(int i = index; i < num.length; i++){
    		tempList.add(num[i]);
    		dfs(result, tempList, num, len, i + 1);
    		tempList.remove(tempList.size() - 1);

    		while(i < num.length - 1 && num[i] == num[i + 1]){
    			i++;
    		}
    	}
    }
}












