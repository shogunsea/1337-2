public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        int numLen = num.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        if(numLen == 0){
        	return result;
        }

        Arrays.sort(num);

        for(int i = 0; i < numLen; i++){
        	if(i != 0){
        		if(num[i] == num[i - 1]){
        			continue;
        		}
        	}

        	int first = num[i];

        	for(int j = i + 1; j < numLen; j++){
        		if(j != i + 1){
        			if(num[j] == num[j - 1]){
        				continue;
        			}
        		}

        		int second = num[j];
        		for(int k = j + 1; k < numLen; k++){
        			if(k != j + 1){
        				if(num[k] == num[k - 1]){
        					continue;
        				}
        			}

        			int third = num[k];
        			if(first + second == -third){
        				tempList.add(first);
        				tempList.add(second);
        				tempList.add(third);
        				result.add(new ArrayList<Integer>(tempList));
        				tempList.clear();
        			}
        		}
        	}
        }

        return result;
    }
}	