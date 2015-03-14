// Given a collection of numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {
    // public List<List<Integer>> permute(int[] num) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();

    //     if(num.length == 0){
    //     	return res;
    //     }

    //     Set<Integer> total = new HashSet<Integer>();
    //     Set<Integer> used = new HashSet<Integer>();
    //     List<Integer> temp;

    //     for(int i : num){
    //     	total.add(i);
    //     }

    //     for(int i : num){
    //     	temp = new ArrayList<Integer>();
    //     	temp.add(i);
    //     	used.add(i);
    //     	dfs(res, temp, total, used);
    //     	// temp.remove(temp.size() - 1);
    //     	used.remove(i);
    //     }

    //     return res;
    // }

    // public void dfs(List<List<Integer>> res, List<Integer> temp, Set<Integer> total, Set<Integer> used){
    // 	if(temp.size() == total.size()){
    // 		res.add(new ArrayList<Integer>(temp));
    // 		temp = new ArrayList<Integer>();
    // 		return;
    // 	}

    // 	for(Integer i : total){
    // 		if(!used.contains(i)){
    // 			temp.add(i);
	   //      	used.add(i);
	   //      	dfs(res, temp, total, used);
	   //      	// temp.remove(temp.size() - 1);
	   //      	used.remove(i);
    // 		}
    // 	}
    // }

    public List<List<Integer>> permute(int[] num){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();

    	if(num.length == 0){
    		return res;
    	}

    	List<Integer> tempList = new ArrayList<Integer>();

    	dfs(res, tempList, num);

    	return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempList, int[] num){
    	if(tempList.size() == num.length){
    		res.add(new ArrayList<Integer>(tempList));
    		return;
    	}

    	for(int i : num){
    		if(!tempList.contains(i)){
    			tempList.add(i);
    			dfs(res, tempList, num);
    			tempList.remove(tempList.size() - 1);
    		}
    	}
    }
}



public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = num.length;

        if (len == 0) {
            return res;
        }  

        List<Integer> tempList = new ArrayList<Integer>();
        boolean[] used = new boolean[len];

        for (int i = 0; i < len; i++) {
            // each element as first in the list.
            tempList.add(num[i]);
            used[i] = true;
            dfsHelper(res, tempList, num, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }

        return res;
    }

    public void dfsHelper(List<List<Integer>> res, List<Integer> tempList, int[] num, boolean[] used) {
        if (tempList.size() == num.length) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                tempList.add(num[i]);
                used[i] = true;
                dfsHelper(res, tempList, num, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);

            }
        }
    }
}