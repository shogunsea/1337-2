// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

public class Solution {
    public int longestConsecutive(int[] num) {
        if(num.length <= 1) return num.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i : num){
        	map.put(i, 1);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < num.length; i++){
        	int curNum= num[i];

        	if(map.containsKey(curNum)){
        		int count = 1;

        		int bigger = curNum + 1;
        		int smaller = curNum - 1;

        		while(map.containsKey(bigger)){
        			count++;
        			map.remove(bigger);
        			bigger++;
        		}

        		while(map.containsKey(smaller)){
        			count++;
        			map.remove(smaller);
        			smaller--;
        		}

        		max = Math.max(max, count);
        	}
        }

        return max;
    }
}