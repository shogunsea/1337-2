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
    	boolean[] visited = new boolean[num.length];
    	dfs(res, tempList, num, visited);

    	return res;
	}

	public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] num, boolean[] visited){
		if(tempList.size() == num.length){
			res.add(new ArrayList<Integer>(tempList));
			return;
		}

		for(int i = 0; i < num.length; i++){
			if(visited[i] || i !=0 && num[i] == num[i - 1] && !visited[i - 1]){
				continue;
			}

			visited[i] = true;
			tempList.add(num[i]);
			dfs(res, tempList, num, visited);
			visited[i] = false;
			tempList.remove(tempList.size() - 1);
		}
	}
}



public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
		// idea: at current position, we dont use dups at differnt
		// elemnts, but dups can show at differnt index.
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = num.length;

		if (len == 0) {
			return res;
		}

		Arrays.sort(num);
		List<Integer> tempList = new ArrayList<Integer>();
		boolean[] used = new boolean[len];

		for (int i = 0; i < len; i++) {
			tempList.add(num[i]);
			used[i] = true;
			dfsHelper(res, tempList, num, used);
			tempList.remove(tempList.size() - 1);
			used[i] = false;
		}

		return res;
    }

    public void dfsHelper(List<List<Integer>> res, List<Integer> tempList, int[] num, boolean[] used) {
    	if (tempList.size() == num.length) {
    		res.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for (int i = 0; i < num.length; i++) {
    		if (i != 0 && num[i] == num[i - 1] && used[i - 1]) {
    			continue;
    		} else if (used[i]) {
    			continue;
    		}

    		used[i] = true;
    		tempList.add(num[i]);
    		dfsHelper(res, tempList, num, used);
    		used[i] = false;
    		tempList.remove(tempList.size() - 1);
    	}
    }
}