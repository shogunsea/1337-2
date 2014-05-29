// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int len = numbers.length;

    	if(len == 0){
    		return numbers;
    	}

    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];

		for(int i = 0; i < len; i++){
			int num = numbers[i];
			map.put(num, i);
		}

		for(int i = 0; i < len; i++){
			int left = numbers[i];
			int right = target - left;
			if(map.containsKey(right) && map.get(right) != i){
				res[0] = i + 1;
				res[1] = map.get(right) + 1;
				return res;
			}
		}

    	return res;
    }
}