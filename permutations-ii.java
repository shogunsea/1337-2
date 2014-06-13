// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

    	if(num.length == 0){
    		return res;
    	}

    	Arrays.sort(num);
    	List<Integer> tempList = new ArrayList<Integer>();
    	int[] visited = new int[num.length];

    	dfs(res, tempList, num, visited);

    	return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] num, int[] visited){
    	if(tempList.size() == num.length){
    		res.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for(int i = 0; i < num.length; i++){
    		if(visited[i] == 1 || i!=0 && num[i] == num[i - 1] && visited[i - 1] == 0){
    			continue;
    		}

    		visited[i] = 1;
    		tempList.add(num[i]);
    		dfs(res, tempList, num, visited);
    		visited[i] = 0;
    		tempList.remove(tempList.size() - 1);
    	}
    }
}